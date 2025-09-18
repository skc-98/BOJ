import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 운동기구의 수
		int n = Integer.parseInt(br.readLine());

		// 운동기구 저장할 배열
		long[] d = new long[n];

		// 운동기구 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Long.parseLong(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 답
		long ans = 0;

		// 짝수인 경우
		if (n % 2 == 0) {
			for (int i = 0; i < n / 2; i++) {
				long sum = d[i] + d[n - i - 1];
				ans = Math.max(ans, sum);
			}
		}

		// 홀수인 경우
		else {
			ans = Math.max(ans, d[n - 1]);
			for (int i = 0; i < n / 2; i++) {
				long sum = d[i] + d[n - i - 2];
				ans = Math.max(ans, sum);
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
