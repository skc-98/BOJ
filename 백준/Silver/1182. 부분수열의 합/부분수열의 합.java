import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n, s;
	static int[] d;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정수의 수 합의 값
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		// 정수 입력
		d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 부분집합 호출
		backTracking(0, 0);

		// 공집합 제외
		if (s == 0)
			ans--;

		// 답 출력하기
		System.out.print(ans);
	}

	// 부분집합 메서드
	static void backTracking(int now, int sum) {
		// 합이 s라면 답 증가
		if (now == n) {
			if (sum == s) {
				ans++;
			}
			return;
		}

		// 현재 원소를 더한 경우
		backTracking(now + 1, sum + d[now]);

		// 현재 원소를 더하지 않은 경우
		backTracking(now + 1, sum);
	}
}
