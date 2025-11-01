import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 일수, 일을 할 수 있는 일 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 알바비 배열
		int[] d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 누적 합 구해두기
		long[] psum = new long[n];
		psum[0] = d[0];
		for (int i = 1; i < n; i++) {
			psum[i] = psum[i - 1] + d[i];
		}

		// 답 변수
		long ans = 0;

		// 슬라이딩 윈도우
		int start = 0, end = 0;
		while (end < n) {
			if (end - start + 1 < m) {
				end++;
			} else if (end - start + 1 == m) {
				long now;
				if (start == 0)
					now = psum[end];
				else
					now = psum[end] - psum[start - 1];
				ans = Math.max(ans, now);
				start++;
				end++;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
