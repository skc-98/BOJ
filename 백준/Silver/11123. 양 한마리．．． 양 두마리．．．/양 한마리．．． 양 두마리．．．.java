import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 배열
			char[][] d = new char[n][m];
			boolean[][] visit = new boolean[n][m];

			// 배열 입력
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					d[i][j] = s.charAt(j);
				}
			}

			// BFS를 위한 큐
			Queue<int[]> q = new ArrayDeque<>();

			// 답을 저장할 변수
			int ans = 0;

			// BFS 시작
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visit[i][j] && d[i][j] == '#') {
						ans++;
						q.add(new int[] { i, j });
						visit[i][j] = true;

						// 큐가 빌때까지
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.peek()[1];
							q.poll();

							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] != '#')
									continue;

								q.add(new int[] { nx, ny });
								visit[nx][ny] = true;
							}
						}
					}
				}
			}

			// 답 출력하기
			System.out.println(ans);
		}
	}
}
