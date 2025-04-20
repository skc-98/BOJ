import java.util.*;
import java.io.*;

public class Main {
	// 4방향 정의
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 공간의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 공간의 정보를 저장할 배열
		int[][] d = new int[n][n];

		// 아기 상어의 좌표, 크기
		int bx = 0, by = 0;
		int bsize = 2;

		// 답이 될 전체 시간
		int time = 0;

		// 공간의 정보 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());

				// 아기 상어의 위치 미리 저장하고 해당 좌표 0으로 초기화
				if (d[i][j] == 9) {
					bx = i;
					by = j;
					d[i][j] = 0;
				}
			}
		}

		// 상어가 현재까지 먹은 물고기의 수
		int eatCount = 0;

		// 이동할 수 없을때까지 시뮬레이션
		while (true) {
			// 상어가 먹을 수 있는 물고기의 좌표를 우선순위 큐로 관리
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
				if (a[2] != b[2])
					return a[2] - b[2];
				if (a[0] != b[0])
					return a[0] - b[0];
				return a[1] - b[1];
			});

			// BFS 탐색을 위한 큐, 방문 배열
			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visit = new boolean[n][n];

			// 큐에 시작점 삽입
			q.add(new int[] { bx, by, 0 });
			visit[bx][by] = true;

			// BFS 탐색을 통해 먹을 수 있는 물고기의 좌표를 우선순위 큐에 저장
			while (!q.isEmpty()) {
				// 가장 앞 요소 꺼내기
				int x = q.peek()[0];
				int y = q.peek()[1];
				int dist = q.peek()[2];
				q.poll();

				// 4방 탐색
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 초과 검사, 방문 검사
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
						continue;

					// 현재 상어의 크기보다 큰 칸으로는 이동 불가
					if (d[nx][ny] > bsize)
						continue;

					// 이동 가능한 칸 큐에 넣고, 혹시 물고기 칸이면 리스트에도 추가
					q.add(new int[] { nx, ny, dist + 1 });
					visit[nx][ny] = true;
					if (d[nx][ny] != 0 && d[nx][ny] < bsize) {
						pq.add(new int[] { nx, ny, dist + 1 }); // 좌표와 거리 저장
					}
				}
			}

			// 먹을 수 있는 물고기가 없으면 종료
			if (pq.isEmpty()) {
				System.out.println(time);
				return;
			}

			// 우선순위가 가장 높은 물고기 좌표로 옮기고, 거리만큼 시간 증가, 우선순위 큐에서 빼기
			bx = pq.peek()[0];
			by = pq.peek()[1];
			time += pq.peek()[2];
			pq.poll();

			// 해당 좌표 0으로 바꾸고 먹은 물고기 수 카운트
			d[bx][by] = 0;
			eatCount++;

			// 만약 자신의 크기만큼 먹었으면 상어 사이즈 증가
			if (eatCount == bsize) {
				bsize++;
				eatCount = 0;
			}
		}
	}
}
