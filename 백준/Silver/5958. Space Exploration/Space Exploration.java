import java.util.*;
import java.io.*;

public class Main {
	// 4방 벡터 생성
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 그래프 크기
		int n = Integer.parseInt(br.readLine());

		// 그래프 배열
		char[][] d = new char[n][n];

		// 그래프 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// BFS용 큐랑 방문배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];

		// 답 변수
		int ans = 0;

		// 모든 칸 돌면서
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i][j] == '*' && !visit[i][j]) {
					ans++;
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

							// 행성검사, 방문검사, 범위검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] != '*') {
								continue;
							}

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
