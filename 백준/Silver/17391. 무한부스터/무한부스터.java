import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵의 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 맵 상태 입력
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 아이템을 획득하게 되는 격자 수
		int[][] dist = new int[n][m];

		// BFS 세팅
		Queue<int[]> q = new ArrayDeque<>();
		dist[0][0] = 1;
		q.add(new int[] { 0, 0 });

		// BFS 돌리기
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 도착 시 종료
			if (x == n - 1 && y == m - 1) {
				System.out.print(dist[x][y]);
				return;
			}

			int jump = d[x][y];

			// 오른쪽으로
			int rightLimit = Math.min(m - 1, y + jump);
			for (int ny = y + 1; ny <= rightLimit; ny++) {

				// 도착 칸이면: 도착 즉시 종료 -> 도착칸에서 아이템 획득 X
				if (x == n - 1 && ny == m - 1) {
					System.out.print(dist[x][y]);
					return;
				}

				if (dist[x][ny] != 0)
					continue;
				dist[x][ny] = dist[x][y] + 1;
				q.add(new int[] { x, ny });
			}

			// 아래로
			int downLimit = Math.min(n - 1, x + jump);
			for (int nx = x + 1; nx <= downLimit; nx++) {

				if (nx == n - 1 && y == m - 1) {
					System.out.print(dist[x][y]);
					return;
				}

				if (dist[nx][y] != 0)
					continue;
				dist[nx][y] = dist[x][y] + 1;
				q.add(new int[] { nx, y });
			}
		}

		// 불가능한 경우 -1
		System.out.print(-1);
	}
}
