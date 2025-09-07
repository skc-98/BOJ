import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 두 문자열 입력
		String s1 = br.readLine();
		String s2 = br.readLine();
		int n = s1.length();
		int m = s2.length();

		// dp 배열
		int[][] dp = new int[n + 1][m + 1];

		// 답 구하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// 답 출력
		System.out.println(dp[n][m]);
	}
}
