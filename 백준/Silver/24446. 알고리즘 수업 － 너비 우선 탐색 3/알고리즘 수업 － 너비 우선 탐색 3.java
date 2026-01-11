import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n, m, start;
	static List<List<Integer>> li;
	static int[] visit;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 수, 간선의 수, 시작 정점
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		// 간선 정보 담을 리스트 생성
		li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 각 간선의 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			li.get(from).add(to);
			li.get(to).add(from);
		}

		// BFS 시작
		visit = new int[n + 1];
		Arrays.fill(visit, -1);
		bfs(start);

		// 출력하기
		for (int i = 1; i <= n; i++) {
			System.out.println(visit[i]);
		}
	}

	// BFS 메서드
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visit[start] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : li.get(now)) {
				if (visit[next] != -1)
					continue;

				visit[next] = visit[now] + 1;
				q.add(next);
			}
		}
	}
}
