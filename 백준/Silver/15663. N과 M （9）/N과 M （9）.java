import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언
	static int n, m;
	static int[] d;
	static int[] result;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N과 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 수열 입력
		d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 전역 배열 초기화
		result = new int[m];
		visit = new boolean[n];

		// 백트래킹
		backTracking(0, 0);
	}

	// 백트래킹
	static void backTracking(int now, int depth) {
		// 깊이 도달시
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		int prev = -1;
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			if (d[i] == prev)
				continue;

			visit[i] = true;
			result[depth] = d[i];
			prev = d[i];
			backTracking(i, depth + 1);
			visit[i] = false;
		}
	}
}
