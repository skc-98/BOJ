import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료 시까지 반복
		while (true) {
			// 크기 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 종료 조건
			if (n == 0 && m == 0)
				break;

			// 상태 입력
			int sx = 0, sy = 0;
			char[][] d = new char[m][n];
			for (int i = 0; i < m; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					d[i][j] = s.charAt(j);
					if (d[i][j] == '@') {
						sx = j;
						sy = i;
					}
				}
			}

			// BFS 세팅
			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visit = new boolean[m][n];

			// 시작 좌표 넣기
			q.add(new int[] { sx, sy });
			visit[sy][sx] = true;
			int ans = 1;

			// BFS 돌기
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();

				// 4방 탐색
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 검사, 방문 검사, 블록 검사
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[ny][nx] || d[ny][nx] == '#')
						continue;

					// 값 증가 후 다음 좌표 넣기
					ans++;
					q.add(new int[] { nx, ny });
					visit[ny][nx] = true;
				}
			}

			// 답 출력하기
			System.out.println(ans);
		}
	}
}
