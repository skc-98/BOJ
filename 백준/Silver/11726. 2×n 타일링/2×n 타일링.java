import java.util.*;
import java.io.*;

// dp 문제임, 주의사항: 값이 크니까 계산 과정에서 10,007로 나누면서 해야함
public class Main{
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// dp 배열 생성, 초기화
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		// dp 구하기
		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}

		// 답 출력하기
		System.out.println(dp[n]);
	}
}

/* 점화식 구하기
1 => 1
2 => 2
3 => 3
4 => 5
5 => 8
피보나치 수열임
f(n)=f(n-2)+f(n-1)
*/