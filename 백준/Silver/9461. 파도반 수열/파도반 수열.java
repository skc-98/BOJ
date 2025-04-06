import java.util.*;
import java.io.*;

// dp 문제고 점화식이 피보나치 수열과 비슷한 간단한 문제임, 또한 미리 다 구해두면 테케마다 연산 다시할 필요없음
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 모든 수열 값 미리 구해놓기
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		// dp 연산 수행하기
		for (int i = 4; i <= 100; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}

		// 테스트 케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// n 입력
			int n = Integer.parseInt(br.readLine());

			// 답 출력하기
			System.out.println(dp[n]);
		}
	}
}

/* 점화식 구하기
1 => 1
2 => 1
3 => 1
4 => 2
5 => 2
6 => 3
7 => 4
8 => 5
9 => 7
10 => 9
f(n) = f(n-3)+f(n-2) 임
*/