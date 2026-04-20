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
		for (int tc = 1; tc <= tcn; tc++) {
			// 격자 크기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 시작 좌표
			int sx = 0, sy = 0;

			// 격자 상태 입력
			char[][] d = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					d[i][j] = s.charAt(j);
					if (d[i][j] == 'S') {
						sx = i;
						sy = j;
					}
				}
			}

			// 답 변수
			int ans = Integer.MAX_VALUE;

			// BFS 세팅
			Queue<int[]> q = new ArrayDeque<>();
			int[][] visit = new int[n][m];
			q.add(new int[] { sx, sy });
			visit[sx][sy] = 0;

			// BFS 돌리기
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();

				// 4방 탐색
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 검사, 장애물 검사
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] == 'X' || visit[nx][ny] != 0)
						continue;

					// 게이트면
					if (d[nx][ny] == 'G') {
						if (ans > visit[x][y] + 1) {
							ans = visit[x][y] + 1;
							continue;
						}
					}

					// 다음 좌표 넣기
					q.add(new int[] { nx, ny });
					visit[nx][ny] = visit[x][y] + 1;
				}
			}

			// 답 출력하기
			if (ans == Integer.MAX_VALUE) {
				System.out.println("No Exit");
			} else {
				System.out.printf("Shortest Path: %d\n", ans);
			}
		}
	}
}
