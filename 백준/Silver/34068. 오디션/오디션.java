import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언
	static int n, m;
	static long ans = 0;
	static long[] cnt;

	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 참가자의 수, 결투 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 카운트 배열 초기화
		cnt = new long[n + 1];

		// 결투 결과 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cnt[a]++;
		}

		// 정렬
		Arrays.sort(cnt, 1, n + 1);

		long now = -1;
		for (int i = 1; i <= n; i++) {
			now = Math.max(now + 1, cnt[i]);
			ans += now - cnt[i];
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
