import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 국기의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 국기 A 입력
		char[][] d1 = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d1[i][j] = s.charAt(j);
			}
		}

		// 국기 B 입력
		char[][] d2 = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d2[i][j] = s.charAt(j);
			}
		}

		// 방문 배열 생성
		boolean[][] visit = new boolean[n][m];

		// BFS 돌리기
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					// 각 국기 색상
					char color1 = d1[i][j];
					char color2 = d2[i][j];

					q.add(new int[] { i, j });
					visit[i][j] = true;

					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 색 다르면 바로 종료
						if (d2[x][y] != color2) {
							System.out.println("NO");
							return;
						}

						// 4방 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위 검사, 방문 검사, 색 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d1[nx][ny] != color1)
								continue;

							visit[nx][ny] = true;
							q.add(new int[] { nx, ny });
						}
					}
				}
			}
		}

		// 되는 경우 답 출력하기
		System.out.println("YES");
	}
}
