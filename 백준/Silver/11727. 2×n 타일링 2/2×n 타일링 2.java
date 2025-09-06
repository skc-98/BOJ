import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// dp 배열 생성
		int[] dp = new int[n + 1];
		dp[1] = 1;
		if (n >= 2)
			dp[2] = 3;

		// 계속 채우면 됨
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		// 답 출력하기
		System.out.print(dp[n]);
	}
}
