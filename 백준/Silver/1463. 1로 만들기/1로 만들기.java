import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1로 만들어야하는 숫자 입력
		int target = Integer.parseInt(br.readLine());

		// dp배열 생성
		int[] dp = new int[target + 1];

		// dp 연산을 통한 각 최소 횟수 구하기
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= target; i++) {
			dp[i] = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}

		System.out.println(dp[target]);
	}
}
