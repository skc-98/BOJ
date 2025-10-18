import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 포도주 잔의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 포도주 배열
		int[] d = new int[n];

		// 포도주 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// dp배열 생성
		int[] dp = new int[n];

		// n이 1, 2인 경우
		if (n == 1) {
			System.out.println(d[0]);
			return;
		}
		if (n == 2) {
			System.out.println(d[0] + d[1]);
			return;
		}

		// 초기값 설정
		dp[0] = d[0];
		dp[1] = d[0] + d[1];
		dp[2] = Math.max(d[0] + d[1], Math.max(d[0] + d[2], d[1] + d[2]));

		// dp 진행
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + d[i], dp[i - 3] + d[i - 1] + d[i]));
		}

		// 결과 출력
		System.out.println(dp[n - 1]);
	}
}
