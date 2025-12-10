import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언
	static int n, m, start;
	static List<List<Integer>> li;
	static int[] visit;
	static long[] order;
	static long cnt = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 수, 간선의 수, 시작 정점 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		// 인접 리스트 할당, 방문 배열 할당
		li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}
		visit = new int[n + 1];
		order = new long[n + 1];
		Arrays.fill(visit, -1);

		// 간선의 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			li.get(from).add(to);
			li.get(to).add(from);
		}

		// 간선 정렬해주기
		for (int i = 1; i <= n; i++) {
			Collections.sort(li.get(i));
		}

		// 시작 정점에서 DFS 탐색 시작
		visit[start] = 0;
		dfs(start, 0);

		// 답 구하기
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			if (visit[i] == -1)
				continue;
			ans += (long) visit[i] * order[i];
		}
		System.out.print(ans);
	}

	// DFS 메서드
	static void dfs(int now, int depth) {
		// 현재 정점을 처음 방문했을 경우
		cnt++;
		visit[now] = depth;
		order[now] = cnt;

		// 다음 정점으로 DFS
		for (int i = 0; i < li.get(now).size(); i++) {
			int next = li.get(now).get(i);
			if (visit[next] == -1) {
				dfs(next, depth + 1);
			}
		}
	}
}