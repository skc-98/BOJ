import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 그림의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 맵 생성
		char[][] d = new char[n][m];

		// 맵 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 큐, 방문배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];

		// 답 변수
		int ans = 0;

		// 모든 칸 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] == '*' && !visit[i][j]) {
					ans++;
					q.add(new int[] { i, j });
					visit[i][j] = true;
					// BFS
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 4방 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위검사, 방문검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny])
								continue;

							// 별아니면
							if (d[nx][ny] == '.')
								continue;

							// 새로 넣기
							q.add(new int[] { nx, ny });
							visit[nx][ny] = true;
						}
					}
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
