import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 스티커 배열 크기
			int n = Integer.parseInt(br.readLine());

			// 스티커 배열 생성
			int[][] d = new int[n][2];

			// 스티커 배열 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				d[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				d[i][1] = Integer.parseInt(st.nextToken());
			}

			// dp 배열 생성
			int[][] dp = new int[n][3];
			dp[0][0] = d[0][0];
			dp[0][1] = d[0][1];
			dp[0][2] = 0;

			// 스티커 점수 최댓값 구하기
			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + d[i][0];
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + d[i][1];
				dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
			}

			// 답 출력하기
			int ans = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
			System.out.println(ans);
		}
	}
}
