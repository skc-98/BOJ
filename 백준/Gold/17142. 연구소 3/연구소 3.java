import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int n, m;
	static int[][] d;
	static List<int[]> virus;
	static int zeroCnt;
	static int ans = Integer.MAX_VALUE;
	static boolean[] sel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		d = new int[n][n];
		virus = new ArrayList<>();
		zeroCnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				if (d[i][j] == 2) virus.add(new int[] { i, j });
				if (d[i][j] == 0) zeroCnt++;
			}
		}

		sel = new boolean[virus.size()];

		// 조합 + BFS
		dfs(0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	// dfs는 main 밖으로 분리해야 함!
	static void dfs(int depth, int start) {
		if (depth == m) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			int[][] time = new int[n][n];
			for (int i = 0; i < n; i++) Arrays.fill(time[i], -1);

			// 선택된 바이러스 활성화
			for (int i = 0; i < virus.size(); i++) {
				if (sel[i]) {
					int[] v = virus.get(i);
					q.offer(new int[] { v[0], v[1] });
					visited[v[0]][v[1]] = true;
					time[v[0]][v[1]] = 0;
				}
			}

			int infected = 0;
			int max = 0;

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if (visited[nx][ny]) continue;
					if (d[nx][ny] == 1) continue;

					visited[nx][ny] = true;
					time[nx][ny] = time[cur[0]][cur[1]] + 1;
					q.offer(new int[] { nx, ny });
					if (d[nx][ny] == 0) {
						infected++;
						max = time[nx][ny];
					}
				}
			}

			if (infected == zeroCnt) ans = Math.min(ans, max);
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			sel[i] = true;
			dfs(depth + 1, i + 1);
			sel[i] = false;
		}
	}
}
