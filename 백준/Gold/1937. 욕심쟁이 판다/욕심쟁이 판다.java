import java.util.*;
import java.io.*;

// 단순 DFS 돌렸더니 시간초과나서 메모제이션 추가해서 해결함
// 특정 칸에서 최대 이동 거리를 저장해두고 DFS 탐색을 진행하면
// 다른 칸에서 DFS 탐색 중 해당 칸을 방문했을 때 중복 계산을 무시할 수 있음
public class Main {
	// 이동 방향 4방
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 대나무 숲의 크기
	static int n;

	// 대나무 숲의 정보를 저장할 배열
	static int[][] d;

	// 메모제이션을 위한 배열
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 대나무 숲의 크기 입력
		n = Integer.parseInt(br.readLine());

		// 대나무 숲의 정보 입력
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// dp 배열 초기화
		dp = new int[n][n];

		// 모든 칸에서 DFS 탐색을 진행
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}

	// DFS 탐색 메서드
	static int dfs(int x, int y) {
		// 이미 구한 칸이면 바로 반환
		if (dp[x][y] != 0)
			return dp[x][y];

		// 새로운 칸이면 1로 초기화하고 DFS 시작
		dp[x][y] = 1;

		// 4방향 탐색
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			// 범위 초과 확인
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			// 더 큰 값인지 확인하고 탐색
			if (d[nx][ny] > d[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}
		return dp[x][y];
	}
}
