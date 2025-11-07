import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 막대의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 막대 배열
		int[] d = new int[n];

		// 막대 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 답 저장할 변수
		long ans = 0;

		// 각 막대의 기본 겉넓이
		for (int i = 0; i < n; i++) {
			ans += 2 + (4 * d[i]);
		}

		// 겹치는 부분 제거
		for (int i = 0; i < n - 1; i++) {
			ans -= 2 * Math.min(d[i], d[i + 1]);
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
