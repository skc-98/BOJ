import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 물품의 수, 최대 무게 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		// 각 물건의 무게와 가치를 입력할 배열, 인덱스 1번부터 사용
		int[] weights = new int[n + 1];
		int[] profits = new int[n + 1];

		// 각 물건의 무게와 가치 입력
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}

		// dp 테이블 생성
		int[] dp = new int[w + 1];

		// dp 연산 수행
		for (int i = 1; i <= n; i++) {
			for (int j = w; j >= weights[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weights[i]] + profits[i]);
			}
		}

		// 답 출력하기
		System.out.println(dp[w]);
	}
}
