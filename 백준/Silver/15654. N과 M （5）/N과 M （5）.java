import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		d = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(d);

		visit = new boolean[n + 1];
		backTracking(1);
	}

	static int n, m;
	static int[] d;
	static List<Integer> numbers = new ArrayList<>();
	static boolean[] visit;

	static void backTracking(int cnt) {
		if (numbers.size() == m) {
			for (int i = 0; i < numbers.size(); i++) {
				System.out.print(d[numbers.get(i)] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			numbers.add(i);
			backTracking(i);
			numbers.remove(numbers.size() - 1);
			visit[i] = false;
		}
	}
}
