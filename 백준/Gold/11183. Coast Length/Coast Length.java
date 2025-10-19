import java.util.*;
import java.io.*;

public class Main {
	// 4방 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 격자 생성
		int[][] d = new int[n][m];

		// 격자 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j) - '0';
			}
		}

		// BFS 탐색을 위한 큐와 방문 배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];

		// 모든 칸을 돌면서
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && d[i][j] == 0 && !visit[i][j]) {
					q.offer(new int[] { i, j });
					visit[i][j] = true;
					d[i][j] = -1;

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int dir = 0; dir < 4; dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m)
								continue;
							if (!visit[nx][ny] && d[nx][ny] == 0) {
								visit[nx][ny] = true;
								d[nx][ny] = -1;
								q.offer(new int[] { nx, ny });
							}
						}
					}
				}
			}
		}

		// 해안선 길이 계산
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 육지일때만
				if (d[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						// 격자 밖이거나 외부가 -1이면 해안선
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || d[nx][ny] == -1) {
							ans++;
						}
					}
				}
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}