import java.util.*;
import java.io.*;

public class Main {
	// 4방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료까지 입력
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// 둘다 0이면 종료
			if (n == 0 && m == 0)
				break;

			// 격자 생성
			char[][] d = new char[n][m];

			// 격자 입력
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					d[i][j] = s.charAt(j);
				}
			}

			// BFS 탐색을 위한 방문 배열과 큐
			boolean[][] visit = new boolean[n][m];
			Queue<int[]> q = new ArrayDeque<>();

			// 플러드필
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (d[i][j] == 'S' && !visit[i][j]) {
						// 해당 원소 큐에 넣고 방문 처리
						q.add(new int[] { i, j });
						visit[i][j] = true;

						// BFS 탐색 시작
						while (!q.isEmpty()) {
							// 첫 원소 빼기
							int x = q.peek()[0];
							int y = q.peek()[1];
							q.poll();

							// 4방 탐색
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];

								// 범위 검사, 방문 검사, T 검사
								if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] != 'T') {
									continue;
								}

								q.add(new int[] { nx, ny });
								visit[nx][ny] = true;
								d[nx][ny] = 'S';
							}
						}
					}
				}
			}

			// 출력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(d[i][j]);
				}
				System.out.println();
			}
		}
	}
}
