import java.util.*;
import java.io.*;

// 아이디어
// 다리를 딱 하나만 놓으면 되는 문제
// 다리의 시작점이 되는 모든 점을 찾기
// 시작점이 되는 모든 점에서 BFS 탐색을 통해 가장 짧은 다리 구하기
public class Main {
	// 탐색 방향 4가지
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도의 크기 n 입력
		int n = Integer.parseInt(br.readLine());

		// 지도의 정보를 저장할 배열
		int[][] d = new int[n][n];

		// 지도의 정보 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 섬에 번호 붙혀서 카운트
		Queue<int[]> q = new ArrayDeque<>();

		// 섬 수를 카운트할 변수, 섬 번호 부여하려고 사용함
		int landNumber = 0;

		// 섬 번호 붙힐때 사용할 방문 배열
		boolean[][] visitedLand = new boolean[n][n];

		// 각 섬에 번호 붙히기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 아직 방문하지 않은 섬이면 큐에 추가
				if (d[i][j] != 0 && !visitedLand[i][j]) {
					// 큐에 넣으면서 섬 개수 카운트
					landNumber++;
					q.add(new int[] { i, j });
					visitedLand[i][j] = true;
					d[i][j] = landNumber;

					// BFS로 하나의 섬 처리
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 4방향 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위 초과 검사, 방문 검사, 섬이 맞는지 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || visitedLand[nx][ny] || d[nx][ny] == 0)
								continue;

							// 같은 섬인 칸이면 큐에 넣고 번호 붙히기
							d[nx][ny] = landNumber;
							q.add(new int[] { nx, ny });
							visitedLand[nx][ny] = true;
						}
					}
				}
			}
		}

		// 다리 시작점이 될 수 있는 좌표를 저장할 리스트
		List<int[]> startList = new ArrayList<>();

		// 다리 시작점이 될 수 있는 칸 리스트에 추가하기
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
							startList.add(new int[] { i, j, d[i][j] });
							break;
						}
					}
				}
			}
		}

		// 답을 저장할 변수, 가장 짧은 다리 길이 구하는 거니까 최대로 초기화
		int ans = Integer.MAX_VALUE;

		// 현재 리스트에 저장 된 다리의 시작점에서 BFS 탐색을 통해 다리를 잇고 가장 짧은 다리 구하기
		for (int i = 0; i < startList.size(); i++) {
			int cx = startList.get(i)[0];
			int cy = startList.get(i)[1];
			int cNum = startList.get(i)[2];

			// 큐에 좌표와 지금까지 거리 추가
			q.clear();
			q.add(new int[] { cx, cy, 0 });

			// BFS 방문 처리를 위한 배열
			boolean[][] visit = new boolean[n][n];
			visit[cx][cy] = true;

			// BFS 탐색
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int distance = q.peek()[2];
				q.poll();

				// 만약 현재 칸이 다른 섬이라면 다리 생성임, 거리가 더 짧으면 ans 갱신
				if (d[x][y] != 0 && d[x][y] != cNum) {
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

		// 답 출력하기
		System.out.print(ans);
	}
}
