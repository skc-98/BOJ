import java.util.*;
import java.io.*;

public class Main {
	// 전역 선언부
	static int n;
	static List<Integer>[] to;
	static List<Integer>[] cost;
	static boolean[] visit;
	static long ans;

	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 방의 수
		n = Integer.parseInt(br.readLine());

		// 인접 리스트 생성
		to = new ArrayList[n + 1];
		cost = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			to[i] = new ArrayList<>();
			cost[i] = new ArrayList<>();
		}

		// n-1개의 연결 관계 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			to[from].add(next);
			cost[from].add(value);
			to[next].add(from);
			cost[next].add(value);
		}

		// DFS로 최대 거리 구하기
		visit = new boolean[n + 1];
		ans = 0;
		dfs(1, 0);

		// 답 출력하기
		System.out.println(ans);
	}

	// DFS 메서드
	static void dfs(int now, long sum) {
		visit[now] = true;

		// 가장 먼 거리 갱신
		if (sum > ans) {
			ans = sum;
		}

		// 연결된 노드들 탐색
		for (int i = 0; i < to[now].size(); i++) {
			int next = to[now].get(i);
			int value = cost[now].get(i);

			if (!visit[next]) {
				dfs(next, sum + value);
			}
		}
	}
}
