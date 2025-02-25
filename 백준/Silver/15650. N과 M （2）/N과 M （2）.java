import java.util.*;
import java.io.*;

// 아이디어
// n개의 수 중에서 m개를 선택해 순열을 출력하는 문제입니다. 중복을 제거해야 합니다.
public class Main {
	// n과 m 전역변수 선언
	static int n;
	static int m;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 백트래킹 시작
		visit = new boolean[n];
		backTracking(0, 0);
	}

	static void backTracking(int cnt, int start) {
		// m개를 선택했으면 출력
		if (cnt == m) {
			for (int i = 0; i < n; i++) {
				if (visit[i])
					System.out.print((i + 1) + " ");
			}
			System.out.println();
			return;
		}

		// 조합 만들기
		for (int i = start; i < n; i++) {
			visit[i] = true;
			backTracking(cnt + 1, i + 1);
			visit[i] = false;
		}
	}
}
