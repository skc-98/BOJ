import java.util.*;
import java.io.*;

public class Main {
	// 4방 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 격자 생성
		char[][] d = new char[n][m];

		// 격자 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// BFS용 큐랑 방문 배열, 답 변수
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[n][m];
		int ans = 0;

		// 플러드 필
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] == '*' && visit[i][j] == 0) {
					q.add(new int[] { i, j });
					visit[i][j] = 1;

					int cnt = 1;

					// BFS 시작
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 4방 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위 검사, 방문 검사, 영역 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] != 0 || d[nx][ny] != '*') {
								continue;
							}

							q.add(new int[] { nx, ny });
							visit[nx][ny] = visit[x][y] + 1;
							cnt++;
						}
					}

					// 최댓값 갱신 확인
					ans = Math.max(ans, cnt);
				}
			}
		}

		// 가장 큰 영역 출력
		System.out.print(ans);
	}
}
