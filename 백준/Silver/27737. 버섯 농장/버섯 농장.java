import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n;
	static long m, k;
	static int[][] d;
	static boolean[][] visit;

	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N, M, K 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		// 맵 입력
		d = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 필요한 포자, 버섯이 자랄 칸 수
		long need = 0;
		int zeroCount = 0;

		// 연결요소 크기 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i][j] == 0)
					zeroCount++;

				if (d[i][j] == 0 && !visit[i][j]) {
					int size = dfs(i, j);

					long compNeed = size / k;
					if (size % k != 0)
						compNeed++;

					need += compNeed;

					// 불가능한 경우
					if (need > m) {
						System.out.print("IMPOSSIBLE");
						return;
					}
				}
			}
		}

		// 0이 하나도 없으면 불가능, 필요한 포자 수가 0이면 제외
		if (zeroCount == 0 || need > m) {
			System.out.print("IMPOSSIBLE");
			return;
		}

		// 답 출력하기
		System.out.println("POSSIBLE");
		System.out.print(m - need);
	}

	// DFS 메서드
	static int dfs(int x, int y) {
		int cnt = 0;

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.push(new int[] { x, y });
		visit[x][y] = true;

		while (!dq.isEmpty()) {
			int cx = dq.peek()[0];
			int cy = dq.peek()[1];
			dq.pop();
			cnt++;

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] != 0)
					continue;

				visit[nx][ny] = true;
				dq.push(new int[] { nx, ny });
			}
		}

		return cnt;
	}
}