import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 노드의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 부모 배열 생성, index 1번부터 사용
		int[] parent = new int[n + 1];

		// 인접 리스트를 통해 트리 관리하기
		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 연결된 정점 정보 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start].add(end);
			graph[end].add(start);
		}

		// BFS를 위한 큐와 방문 배열
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n + 1];

		// 루트인 1 시작점으로 큐에 넣고 방문 처리
		q.add(1);
		visit[1] = true;

		// BFS 시작
		while (!q.isEmpty()) {
			// 맨 앞 노드 꺼내기
			int now = q.poll();

			// 인접 리스트 돌면서 BFS 탐색
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (!visit[next]) {
					parent[next] = now;
					visit[next] = true;
					q.add(next);
				}
			}
		}

		// 답 출력하기, 2번 부터 n번까지 부모 출력
		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i] + " ");
		}
	}
}
