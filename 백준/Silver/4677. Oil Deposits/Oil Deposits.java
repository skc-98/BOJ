import java.util.*;
import java.io.*;

public class Main {
	// 8방 벡터 생성
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 입력 종료 조건
			if (n == 0 && m == 0)
				break;

			// 배열 생성
			char[][] d = new char[n][m];

			// 배열 입력
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					d[i][j] = s.charAt(j);
				}
			}

			// BFS용 큐와 방문 배열 생성
			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visit = new boolean[n][m];

			// 답 변수
			int ans = 0;

			// 플러드 필
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 석유 지대고 아직 방문 안했으면
					if (d[i][j] == '@' && !visit[i][j]) {
						ans++;
						// 큐에 넣기
						q.add(new int[] { i, j });
						visit[i][j] = true;

						// BFS 시작
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.peek()[1];
							q.poll();

							// 8방 탐색
							for (int k = 0; k < 8; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];

								// 범위 검사, 방문 확인, 석유 칸인지 확인
								if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] != '@') {
									continue;
								}

								// 조건에 맞으면 큐에 넣기
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
