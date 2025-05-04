import java.util.*;
import java.io.*;

public class Main {
	// 방향 처리
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n, m, k 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 영역을 저장할 배열
		int[][] d = new int[n][m];

		// 영역의 상태 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// BFS 탐색을 위한 큐와 방문 배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];

		// 모든 정점 방문하면서 방문하지 않았으면 BFS 탐색 시작
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					// 답 증가
					ans++;

					// 시작점 큐에 넣기
					q.add(new int[] { i, j });
					visit[i][j] = true;

					// BFS 시작
					while (!q.isEmpty()) {
						// 맨 앞 요소 빼기
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						// 4방향 탐색
						for (int t = 0; t < 4; t++) {
							int nx = x + dx[t];
							int ny = y + dy[t];

							// 범위 초과 및 방문 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny])
								continue;

							// 높이 차이가 k 이하일 경우만 큐에 다시 추가
							if (Math.abs(d[x][y] - d[nx][ny]) <= k) {
								q.add(new int[] { nx, ny });
								visit[nx][ny] = true;
							}
						}
					}
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
