import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n;
	static int[] d;
	static int[] perm;
	static boolean[] used;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자의 개수
		n = Integer.parseInt(br.readLine());

		// 수 입력하기
		d = new int[n];
		perm = new int[n];
		used = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 순열 호출
		backTracking(0);

		// 답 출력하기
		System.out.print(ans);
	}

	// 순열 메서드
	static void backTracking(int depth) {
		if (depth == n) {
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += Math.abs(perm[i] - perm[i + 1]);
			}
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (used[i])
				continue;

			used[i] = true;
			perm[depth] = d[i];
			backTracking(depth + 1);
			used[i] = false;
		}
	}
}
