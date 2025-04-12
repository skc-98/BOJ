import java.util.*;
import java.io.*;

// 아이디어
// 조합을 통해 3개의 벽을 어디에 둘지 모든 경우 구하고
// 벽을 설치한 뒤 BFS 시뮬레이션을 통해 안전 영역의 수가 최대인 경우를 구하면 그게 답임
public class Main {
	// 지도의 크기
	static int n, m;

	// 지도 배열
	static int[][] d;

	// 빈 칸 위치 저장할 리스트
	static List<int[]> list = new ArrayList<>();

	// 선택한 벽의 인덱스
	static int[] select;

	// 답을 저장할 변수
	static int ans = 0;

	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 지도 배열
		d = new int[n][m];

		// 지도의 모양 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				// 빈 칸은 저장해두기
				if (d[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		// 지도에서 벽을 세울 위치를 결정할 메서드
		select = new int[3];
		wall(0, 0);

		// 답 출력하기
		System.out.print(ans);
	}

	// 3개 벽 위치를 조합으로 구하기
	static void wall(int count, int start) {
		// 벽 3개를 골랐으면
		if (count == 3) {
			// 선택한 벽의 인덱스를 저장할 리스트
			List<int[]> idx = new ArrayList<>();

			// 선택된 벽을 리스트에 저장하고 BFS 메서드 호출
			for (int i = 0; i < 3; i++) {
				idx.add(list.get(select[i]));
			}
			bfs(idx);
			return;
		}
		// 빈 칸들을 순회하며 3개짜리 조합 생성
		for (int i = start; i < list.size(); i++) {
			select[count] = i;
			wall(count + 1, i + 1);
		}
	}

	// BFS 탐색할 메서드
	static void bfs(List<int[]> idx) {
		// 원본 지도 복사해서 map 생성
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = d[i][j];
			}
		}

		// 선택한 위치에 벽 세우기
		for (int i = 0; i < idx.size(); i++) {
			int[] p = idx.get(i);
			map[p[0]][p[1]] = 1;
		}

		// BFS를 위한 큐 생성
		Queue<int[]> q = new ArrayDeque<>();

		// 바이러스의 위치 큐에 다 추가
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		// BFS 탐색으로 바이러스 퍼트리기
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 맵 범위 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				// 빈 칸이면 바이러스 확산
				if (map[nx][ny] == 0) {
					map[nx][ny] = 2;
					q.offer(new int[] { nx, ny });
				}
			}
		}

		// 이제 남은 안전 영역 수 세기
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		// 답 갱신하기
		ans = Math.max(ans, count);
	}
}
