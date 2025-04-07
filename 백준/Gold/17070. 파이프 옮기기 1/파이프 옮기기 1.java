import java.util.*;
import java.io.*;

public class Main {
	// 답을 저장해둘 변수
	static int ans = 0;

	// 집의 크기
	static int n;

	// 집의 상태 저장할 배열
	static int[][] d;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 크기 입력
		n = Integer.parseInt(br.readLine());

		// 집의 상태 입력할 배열
		d = new int[n][n];

		// 집의 상태 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시작점 초기화
		dfs(0, 1, 1);

		// 답 출력하기
		System.out.print(ans);
	}

	// DFS 탐색하는 메서드
	static void dfs(int x, int y, int mode) {
		// 만약 도착점에 도착 했다면 답 증가하고 탐색 종료
		if (x == n - 1 && y == n - 1) {
			ans++;
			return;
		}

		// 가로로 놓였을때
		if (mode == 1) {
			// 가로방향 이동
			if (y + 1 < n && d[x][y + 1] == 0) {
				dfs(x, y + 1, 1);
			}
			// 대각선 방향 이동
			if (x + 1 < n && y + 1 < n && d[x + 1][y + 1] == 0 && d[x][y + 1] == 0 && d[x + 1][y] == 0) {
				dfs(x + 1, y + 1, 3);
			}
		}

		// 세로로 놓였을때
		if (mode == 2) {
			// 세로 방향 이동
			if (x + 1 < n && d[x + 1][y] == 0) {
				dfs(x + 1, y, 2);
			}
			// 대각선 방향 이동
			if (x + 1 < n && y + 1 < n && d[x + 1][y + 1] == 0 && d[x][y + 1] == 0 && d[x + 1][y] == 0) {
				dfs(x + 1, y + 1, 3);
			}
		}

		// 대각선으로 놓였을때
		if (mode == 3) {
			// 가로 방향으로 이동
			if (y + 1 < n && d[x][y + 1] == 0) {
				dfs(x, y + 1, 1);
			}
			// 세로 방향으로 이동
			if (x + 1 < n && d[x + 1][y] == 0) {
				dfs(x + 1, y, 2);
			}
			// 대각선 방향 이동
			if (x + 1 < n && y + 1 < n && d[x + 1][y + 1] == 0 && d[x][y + 1] == 0 && d[x + 1][y] == 0) {
				dfs(x + 1, y + 1, 3);
			}
		}
	}
}
