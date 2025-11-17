import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 교실 수, 학생 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 교실의 점수 입력
		int[] d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 누적합 구하기
		long[] psum = new long[n];
		psum[0] = d[0];
		for (int i = 1; i < n; i++) {
			psum[i] = psum[i - 1] + d[i];
		}

		// 정렬
		Arrays.sort(psum);

		// 큰 값부터 m개 더하기
		long ans = 0;
		for (int i = n - 1; i >= n - m; i--) {
			ans += psum[i];
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
