import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 맵 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 경로 저장용 배열 생성
		int[][] px = new int[n][m];
		int[][] py = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(px[i], -1);
		for (int i = 0; i < n; i++)
			Arrays.fill(py[i], -1);
		px[0][0] = 0;
		py[0][0] = 0;

		// BFS 세팅
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		boolean[][] visit = new boolean[n][m];
		visit[0][0] = true;

		// BFS 시작
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 도착 지점시 종료
			if (x == n - 1 && y == m - 1)
				break;

			// 4방 탐색
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 검사, 이동 검사, 방문 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] == '*')
					continue;

				// 다음 칸 이동
				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
				px[nx][ny] = x;
				py[nx][ny] = y;
			}
		}

		// 경로 리스트에 넣기
		ArrayList<int[]> ans = new ArrayList<>();
		int cx = n - 1, cy = m - 1;
		while (!(cx == 0 && cy == 0)) {
			ans.add(new int[] { cx + 1, cy + 1 });
			int tx = px[cx][cy];
			int ty = py[cx][cy];
			cx = tx;
			cy = ty;
		}
		ans.add(new int[] { 1, 1 });
		Collections.reverse(ans);

		// 답 출력하기
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i)[0] + " " + ans.get(i)[1]);
		}
	}
}
