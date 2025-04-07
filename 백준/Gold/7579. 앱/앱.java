import java.util.*;
import java.io.*;

// 비용을 최소화해서 목표 메모리를 채우는 것이 목표
// 사용되는 요소: 앱 수, 필요한 메모리, 앱 메모리, 앱 비용
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 활성화 된 앱의 수, 필요한 메모리 바이트
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		// 활성화된 앱의 바이트 수 입력
		int[] bytes = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			bytes[i] = Integer.parseInt(st.nextToken());
		}

		// 앱을 비활성화 할 경우의 비용 입력
		int[] costs = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		// 답을 저장할 변수
		int ans = Integer.MAX_VALUE;

		// dp 테이블 생성 => 비용 최댓값은 10000
		// 메모리 범위가 너무 커서 안됨, 비용 기준으로 하면 값 설정할 수가 없음
		int[][] dp = new int[n + 1][10001];

		// dp 연산 수행
		for (int i = 1; i <= n; i++) {
			// 비용이 0이면
			if (costs[i] == 0) {
				for (int j = 0; j <= 10000; j++)
					dp[i][j] = dp[i - 1][j] + bytes[i];
			}
			for (int j = 0; j <= 10000; j++) {
				// 비활성화 하지 않으면
				dp[i][j] = dp[i - 1][j];

				// 현재 앱 비활성화
				if (costs[i] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - costs[i]] + bytes[i]);
					// 최솟값 찾기
					if (dp[i][j] >= w) {
						ans = Math.min(ans, j);
					}
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
