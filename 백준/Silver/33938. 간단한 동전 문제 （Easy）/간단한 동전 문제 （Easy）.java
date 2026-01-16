import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 동전의 종류, 지불할 금액 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// n이 0이면 바로 종료
		if (n == 0) {
			if (m == 0) {
				System.out.println(0);
			} else {
				System.out.println(-1);
			}
			return;
		}

		// 동전의 가치 입력
		int[] d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 범위 제한 걸기
		int min = -2000;
		int max = 2000;

		boolean[] visit = new boolean[max - min + 1];
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> countQueue = new LinkedList<>();

		q.add(0);
		countQueue.add(0);
		visit[0 - min] = true;

		// BFS 돌리기
		while (!q.isEmpty()) {
			int cur = q.poll();
			int cnt = countQueue.poll();

			if (cur == m) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < n; i++) {
				int next = cur + d[i];

				if (next < min)
					continue;
				if (next > max)
					continue;

				if (!visit[next - min]) {
					visit[next - min] = true;
					q.add(next);
					countQueue.add(cnt + 1);
				}
			}
		}

		System.out.println(-1);
	}
}
