import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 영역 크기 입력
			int n = Integer.parseInt(br.readLine());

			// 답 변수
			int ans = 0;

			// 격자 생성 및 입력
			boolean[][] visit = new boolean[n][n];
			char[][] d = new char[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					d[i][j] = s.charAt(j);
				}
			}

			// 큐 생성
			Queue<int[]> q = new ArrayDeque<>();

			// 상하 테두리
			for (int j = 0; j < n; j++) {
				if (d[0][j] == '.' && !visit[0][j]) {
					visit[0][j] = true;
					q.add(new int[] { 0, j });
				}
				if (d[n - 1][j] == '.' && !visit[n - 1][j]) {
					visit[n - 1][j] = true;
					q.add(new int[] { n - 1, j });
				}
			}

			// 좌우 테두리
			for (int i = 0; i < n; i++) {
				if (d[i][0] == '.' && !visit[i][0]) {
					visit[i][0] = true;
					q.add(new int[] { i, 0 });
				}
				if (d[i][n - 1] == '.' && !visit[i][n - 1]) {
					visit[i][n - 1] = true;
					q.add(new int[] { i, n - 1 });
				}
			}

			// BFS로 영역 크기 찾기
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();

				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 검사, 방문 검사
					if (nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny])
						continue;

					if (d[nx][ny] == '.') {
						visit[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][j] == '#')
						ans++;
					else if (d[i][j] == '.' && !visit[i][j])
						ans++;
				}
			}

			// 답 출력하기
			System.out.println(ans);
		}
	}
}
