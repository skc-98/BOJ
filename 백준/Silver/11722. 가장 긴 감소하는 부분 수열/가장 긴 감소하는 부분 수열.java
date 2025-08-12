import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 수열 저장할 배열
		int[] d = new int[n];

		// 수열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// dp 배열
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		// LDS 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (d[j] > d[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		// 답 저장할 변수
		int ans = 0;

		// 답 찾기
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}

		// 답 출력
		System.out.print(ans);
	}
}
