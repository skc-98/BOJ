import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 격자 두개 생성
		int[][] before = new int[n][m];
		int[][] after = new int[n][m];

		// 이전, 이후 격자 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				after[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 답 변수
		boolean changed = false;
		boolean ans = true;

		// BFS 탐색을 위한 큐와 방문 배열
		boolean[][] visit = new boolean[n][m];
		boolean[][] visit2 = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();

		// 방문 로그 추적할 리스트
		List<int[]> li = new ArrayList<>();

		// BFS탐색 동시에 진행
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 리스트 초기화
				li.clear();

				if (!visit[i][j]) {
					// 변화 여부 체크
					if (before[i][j] != after[i][j]) {
						if (changed) {
							ans = false;
							break;
						}
						changed = true;
						int origin = before[i][j];
						int target = after[i][j];
						Queue<int[]> fill = new ArrayDeque<>();
						fill.add(new int[] { i, j });
						before[i][j] = target;
						visit[i][j] = true;
						while (!fill.isEmpty()) {
							int[] cur = fill.poll();
							int cx = cur[0], cy = cur[1];
							for (int k = 0; k < 4; k++) {
								int nx = cx + dx[k];
								int ny = cy + dy[k];
								if (nx < 0 || nx >= n || ny < 0 || ny >= m)
									continue;
								if (visit[nx][ny])
									continue;
								if (before[nx][ny] == origin) {
									before[nx][ny] = target;
									visit[nx][ny] = true;
									fill.add(new int[] { nx, ny });
								}
							}
						}

						// 이 컴포넌트는 처리 끝났으니 다음 칸으로
						continue;
					}

					// 이전 배열 BFS
					int now = before[i][j];
					q.add(new int[] { i, j });
					visit[i][j] = true;
					li.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 4방 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위검사, 방문검사, 값 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || before[nx][ny] != now) {
								continue;
							}

							q.add(new int[] { nx, ny });
							visit[nx][ny] = true;
							li.add(new int[] { nx, ny });
						}
					}
				}
			}
		}
		ans = ans && Arrays.deepEquals(before, after);

		// 답 출력
		if (ans)
			System.out.println("YES");
		else
			System.out.print("NO");
	}
}
