import java.util.*;
import java.io.*;

public class Main {
	// 이동 가능한 방향
	static int[] dx = { -1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 0, 0, -1, 1, 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 말처럼 이동 가능한 횟수 k 입력
		int move = Integer.parseInt(br.readLine());

		// 격자판의 가로, 세로길이 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 격자판의 상태를 저장할 배열
		int[][] d = new int[n][m];

		// 격자판의 상태 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방문 처리를 위한 배열
		int[][][] visit = new int[n][m][move + 1];

		// 원숭이의 시작점 큐에 삽입하기
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, move });
		visit[0][0][move] = 1;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			// 맨 앞 요소 꺼내기
			int x = q.peek()[0];
			int y = q.peek()[1];
			int horse = q.peek()[2];
			q.poll();

			// 목표 지점 도착시 종료하고 답 출력
			if (x == n - 1 && y == m - 1) {
				System.out.println(visit[x][y][horse] - 1);
				return;
			}

			// 4방향 탐색
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 체크, 벽 체크
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] == 1)
					continue;

				// 큐에 다음 값 넣기
				if (visit[nx][ny][horse] == 0) {
					visit[nx][ny][horse] = visit[x][y][horse] + 1;
					q.add(new int[] { nx, ny, horse });
				}
			}

			// 말처럼 이동하는 8방
			if (horse > 0) {
				for (int k = 4; k < 12; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 체크, 벽 체크
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] == 1)
						continue;

					// 큐에 다음 값 넣기, 말처럼 이동한 횟수 -1
					if (visit[nx][ny][horse - 1] == 0) {
						visit[nx][ny][horse - 1] = visit[x][y][horse] + 1;
						q.add(new int[] { nx, ny, horse - 1 });
					}
				}
			}
		}

		// 불가능한 경우 -1 출력하기
		System.out.println(-1);
	}
}
