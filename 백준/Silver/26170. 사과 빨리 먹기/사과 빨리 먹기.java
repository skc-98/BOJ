import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수
	static int[][] d = new int[5][5];
	static int ans = -1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit = new boolean[5][5];

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 입력
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시작 좌표 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// DFS 시작
		visit[x][y] = true;
		dfs(x, y, 0, 0);

		// 답 출력하기
		System.out.print(ans);
	}

	// DFS 메서드
	static void dfs(int x, int y, int depth, int apple) {
		// 사과가 3개면
		if (apple == 3) {
			if (ans == -1) {
				ans = depth;
			} else {
				ans = Math.min(ans, depth);
			}
			return;
		}

		// DFS 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || d[nx][ny] == -1 || visit[nx][ny])
				continue;

			visit[nx][ny] = true;
			if (d[nx][ny] == 0) {
				dfs(nx, ny, depth + 1, apple);
			} else if (d[nx][ny] == 1) {
				dfs(nx, ny, depth + 1, apple + 1);
			}
			visit[nx][ny] = false;
		}
	}
}
