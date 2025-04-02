import java.util.*;
import java.io.*;

// 아이디어
// 1,1부터 n,m으로 이동하기 위해 부숴야 하는 벽의 개수를 구하면 됨
public class Main {
	// 4방향 탐색
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 미로의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 지도를 저장할 배열
		char[][] d = new char[n][m];

		// 지도의 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// BFS 탐색을 위한 큐와 방문배열
		Deque<int[]> dq = new ArrayDeque<>();
		int[][] visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], -1);
		}

		// 시작점 덱에 삽입, 방문 처리
		dq.add(new int[] { 0, 0 });
		visit[0][0] = 0;

		// 덱이 빌때까지 BFS 탐색 시작
		while (!dq.isEmpty()) {
			// 삽입 제외하고는 큐처럼 사용
			int x = dq.peekFirst()[0];
			int y = dq.peekFirst()[1];
			dq.pollFirst();

			// 4방향 탐색, 벽이 아니면 앞으로 벽이면 뒤로 삽입
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 초과, 방문 체크
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] != -1)
					continue;

				// 벽이 아니면 앞으로 삽입
				if (d[nx][ny] == '0') {
					dq.addFirst(new int[] { nx, ny });
					visit[nx][ny] = visit[x][y];
				}
				// 벽이면 뒤로 삽입
				if (d[nx][ny] == '1') {
					dq.addLast(new int[] { nx, ny });
					visit[nx][ny] = visit[x][y] + 1;
				}
			}
		}

		// 답 출력하기
		System.out.print(visit[n - 1][m - 1]);
	}
}
