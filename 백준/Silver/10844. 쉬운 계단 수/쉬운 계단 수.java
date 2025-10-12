import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수 입력
		int n = Integer.parseInt(br.readLine());

		// dp 배열 생성
		long[][] dp = new long[n + 1][10];

		// 초기값
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// dp 값 채우기
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j > 0)
					dp[i][j] += dp[i - 1][j - 1];
				if (j < 9)
					dp[i][j] += dp[i - 1][j + 1];
				dp[i][j] %= 1000000000;
			}
		}

		// 답 변수
		long ans = 0;
		for (int j = 0; j <= 9; j++)
			ans = (ans + dp[n][j]) % 1000000000;

		// 답 출력하기
		System.out.println(ans);
	}

}
