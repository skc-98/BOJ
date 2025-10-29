import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열 길이, 합 조건 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 수열 배열, 입력
		int[] d = new int[n];
		int[] psum = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
			if (i == 0)
				psum[i] = d[i];
			else {
				psum[i] = psum[i - 1] + d[i];
			}
		}

		// 답 변수
		int ans = Integer.MAX_VALUE;

		// 투 포인터 활용 답 구하기
		int before = 0;
		int end = 0;
		while (end < n) {
			int sum;
			if (before == 0) {
				sum = psum[end];
			} else {
				sum = psum[end] - psum[before - 1];
			}

			// m 이상일때
			if (sum >= m) {
				ans = Math.min(ans, end - before + 1);
				before++;
			} else {
				end++;
			}
		}

		// 답 출력하기
		if (ans == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(ans);
	}
}
