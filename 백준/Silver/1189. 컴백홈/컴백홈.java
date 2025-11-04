import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 전역 변수 선언부
	static int n, m, range;
	static char[][] d;
	static boolean[][] visit;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기, 거리 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		d = new char[n][m];
		visit = new boolean[n][m];

		// 격자 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// DFS 시작
		visit[n - 1][0] = true;
		dfs(n - 1, 0, 1);

		// 답 출력하기
		System.out.print(ans);
	}

	// DFS 메서드
	static void dfs(int x, int y, int depth) {
		// 도착한 경우
		if (x == 0 && y == m - 1) {
			if (depth == range) {
				ans++;
			}
			return;
		}

		// 거리가 너무 멀면
		if (depth > range) {
			return;
		}

		// 4방 탐색
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] == 'T') {
				continue;
			}
			visit[nx][ny] = true;
			dfs(nx, ny, depth + 1);
			visit[nx][ny] = false;
		}
	}
}
