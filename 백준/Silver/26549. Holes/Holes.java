import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < tcn; tc++) {
			// 격자의 크기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 격자, 방문배열
			int[][] d = new int[n][m];
			boolean[][] visit = new boolean[n][m];

			// 격자 입력
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					d[i][j] = s.charAt(j);
					if (d[i][j] == '#') {
						visit[i][j] = true;
					}
				}
			}

			// 답 변수, 큐
			int sections = 0;
			int spaces = 0;
			Queue<int[]> q = new ArrayDeque<>();

			// 플러드 필
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (d[i][j] == '.' && !visit[i][j]) {
						sections++;
						spaces++;
						q.add(new int[] { i, j });
						visit[i][j] = true;

						// BFS 돌리기
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.peek()[1];
							q.poll();

							// 4방 탐색
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];

								// 범위, 방문, 격자검사
								if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] == '#') {
									continue;
								}

								// 다음 좌표 넣으면서 칸 더하기
								q.add(new int[] { nx, ny });
								visit[nx][ny] = true;
								spaces++;
							}
						}
					}
				}
			}

			// 답 출력하기
			String word1 = "sections";
			String word2 = "spaces";

			if (sections == 1) {
				word1 = "section";
			}

			if (spaces == 1) {
				word2 = "space";
			}

			System.out.printf("%d %s, %d %s\n", sections, word1, spaces, word2);
		}
	}
}
