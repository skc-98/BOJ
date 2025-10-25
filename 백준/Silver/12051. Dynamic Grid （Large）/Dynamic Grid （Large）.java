import java.util.*;
import java.io.*;

public class Main {
	// 4방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 먼저 출력
			System.out.println("Case #" + tc + ":");

			// 격자 크기 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 격자 생성
			int[][] d = new int[n][m];

			// 격자 입력
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					d[i][j] = s.charAt(j) - '0';
				}
			}

			// 명령의 수 입력
			int orderNumber = Integer.parseInt(br.readLine());

			// 명령 입력
			for (int i = 0; i < orderNumber; i++) {
				String s = br.readLine();
				char orderType = s.charAt(0);

				// M 명령
				if (orderType == 'M') {
					StringTokenizer cmd = new StringTokenizer(s);
					cmd.nextToken();
					int x = Integer.parseInt(cmd.nextToken());
					int y = Integer.parseInt(cmd.nextToken());
					int number = Integer.parseInt(cmd.nextToken());
					d[x][y] = number;
				}

				// Q 명령
				else if (orderType == 'Q') {
					int ans = countArea(d, n, m, 0);
					System.out.println(ans);
				}
			}
		}
	}

	// 영역 개수 세는 메서드
	static int countArea(int[][] d, int n, int m, int count) {
		// BFS용 큐랑 방문 배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 방문하지 않았고 값이 1인 경우 새로운 영역 시작
				if (d[i][j] == 1 && !visit[i][j]) {
					count++;
					q.add(new int[] { i, j });
					visit[i][j] = true;

					// BFS 시작
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 4방 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위, 방문, 1 검사
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || d[nx][ny] != 1) {
								continue;
							}

							visit[nx][ny] = true;
							q.add(new int[] { nx, ny });
						}
					}
				}
			}
		}
		return count;
	}
}
