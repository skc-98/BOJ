import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 각 집을 칠하는 비용(RGB 순서)입력
		int[][] d = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 답을 저장할 변수
		int ans = Integer.MAX_VALUE;

		// 2차원 dp 배열
		int[][] dp = new int[n][3];

		// dp 초기값 세팅
		for (int i = 0; i < 3; i++) {
			dp[0][i] = d[0][i];
		}

		// dp 연산 수행
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + d[i][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 2] + d[i][j]);
				} else if (j == 1) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + d[i][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + d[i][j]);
				} else if (j == 2) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + d[i][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 2] + d[i][j]);
				}
			}
		}

		// 마지막에 최솟값 구하기
		for (int j = 0; j < 3; j++) {
			ans = Math.min(ans, dp[n - 1][j]);
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
