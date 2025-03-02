import java.util.*;
import java.io.*;

public class Main {
	// 탐색 방향 4가지
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 지도의 상태 입력
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 섬에 번호 붙히고 카운트하기
		Queue<int[]> q = new ArrayDeque<>();
		// 섬 수를 카운트할 변수
		int islandCount = 0;
		// 방문 처리를 위한 배열
		boolean[][] islandCheck = new boolean[n][n];
		// 섬 체크를 하면서 다리의 시작점이 될 수 있는 좌표를 저장할 리스트
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// BFS 탐색 처리
				if (d[i][j] != 0 && !islandCheck[i][j]) {
					// 큐에 넣고, 방문 처리 후 섬 갯수 카운트
					islandCount++;
					q.add(new int[] { i, j });
					islandCheck[i][j] = true;
					d[i][j] = islandCount;

					// 하나의 섬 처리
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위 초과 체크
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || islandCheck[nx][ny] || d[nx][ny] == 0)
								continue;

							// 같은 섬인 칸이면 q에 push하고 섬 번호 붙히기
							d[nx][ny] = islandCount;
							q.add(new int[] { nx, ny });
							islandCheck[nx][ny] = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int tx = i + dx[k];
						int ty = j + dy[k];

						// 범위 초과 체크
						if (tx < 0 || tx >= n || ty < 0 || ty >= n)
							continue;

						// 인접 칸이 물이면 다리 건설 시작가능
						if (d[tx][ty] == 0) {
							list.add(new int[] { i, j, d[i][j] });
							break;
						}
					}
				}
			}
		}

		// 답을 저장할 변수
		int ans = Integer.MAX_VALUE;

		// 현재 리스트에 저장 된 다리의 시작점에서 BFS 탐색을 통해 다리를 잇고 가장 잛은 다리 구하기
		for (int i = 0; i < list.size(); i++) {
			int cx = list.get(i)[0];
			int cy = list.get(i)[1];
			int ci = list.get(i)[2];

			// 큐에 좌표와 지금까지 거리 추가
			q.clear();
			q.add(new int[] { cx, cy, 0 });

			// BFS 방문 처리를 위한 배열
			boolean[][] visit = new boolean[n][n];
			visit[cx][cy] = true;

			while (!q.isEmpty()) {
				// 큐 맨 앞의 좌표 꺼내기
				int x = q.peek()[0];
				int y = q.peek()[1];
				int distance = q.peek()[2];
				q.poll();

				// 만약 현재 칸이 다른 섬이면 거리 확인해서 ans 갱신
				if (d[x][y] != 0 && d[x][y] != ci) {
					ans = Math.min(ans, distance - 1);
					break;
				}

				// 4방향 탐색
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 초과, 방문 체크
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
						continue;

					q.add(new int[] { nx, ny, distance + 1 });
					visit[nx][ny] = true;
				}
			}
		}
		// 정답 출력
		System.out.print(ans);
	}
}
