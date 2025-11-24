import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 격자 입력
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j) - '0';
			}
		}

		// 방문배열, 큐
		boolean[][] visit = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();

		// 영역의 수, 리스트
		int ans = 0;
		List<Integer> li = new ArrayList<>();

		// BFS로 영역 개수 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 호수 찾으면
				if (d[i][j] == 1 && !visit[i][j]) {
					ans++;
					int cnt = 0;

					q.add(new int[] { i, j });
					visit[i][j] = true;

					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();
						cnt++;

						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] == 0) {
								continue;
							}

							q.add(new int[] { nx, ny });
							visit[nx][ny] = true;
						}
					}

					// 호수 크기 저장
					li.add(cnt);
				}
			}
		}

		// 크기 정렬
		Collections.sort(li);

		// 답 출력하기
		System.out.println(ans);
		for (int i = 0; i < li.size(); i++) {
			System.out.print(li.get(i) + " ");
		}
	}
}
