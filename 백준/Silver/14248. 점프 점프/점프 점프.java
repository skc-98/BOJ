import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 돌다리의 돌 개수
		int n = Integer.parseInt(br.readLine());

		// 점프할 수 있는 거리
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 시작 점
		int start = Integer.parseInt(br.readLine()) - 1;

		// BFS 세팅
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n];
		q.add(start);
		visit[start] = true;

		// 방문 가능한 돌 개수
		int ans = 1;

		// BFS
		while (!q.isEmpty()) {
			int now = q.poll();

			// 왼쪽
			int left = now - d[now];
			if (left >= 0 && !visit[left]) {
				visit[left] = true;
				q.add(left);
				ans++;
			}

			// 오른쪽
			int right = now + d[now];
			if (right < n && !visit[right]) {
				visit[right] = true;
				q.add(right);
				ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
