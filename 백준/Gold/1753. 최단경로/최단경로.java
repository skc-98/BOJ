import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 개수, 간선의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		// 시작 정점의 번호
		int startV = Integer.parseInt(br.readLine());

		// 인접 리스트 생성
		List<List<int[]>> li = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			li.add(new ArrayList<>());
		}

		// 간선의 정보 입력
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			li.get(start).add(new int[] { end, value });
		}

		// 거리 배열, 최댓값으로 초기화
		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 시작점은 0
		dist[startV] = 0;

		// 우선순위 큐 생성, 시작점 삽입
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		pq.add(new int[] { 0, startV });

		// 다익스트라 진행
		while (!pq.isEmpty()) {
			// 가장 앞 요소 빼기
			int cost = pq.peek()[0];
			int now = pq.peek()[1];
			pq.poll();

			// 만약 현재 거리가 비용보다 낮으면 스킵
			if (dist[now] < cost)
				continue;

			// 현재 정점과 이어진 모든 간선을 돌면서
			for (int[] next : li.get(now)) {
				int nextV = next[0];
				int weight = next[1];

				// 만약에 기존 거리보다 현재 간선을 타는게 더 싸면 바꾸고 큐에 삽입
				if (dist[nextV] > dist[now] + weight) {
					dist[nextV] = dist[now] + weight;
					pq.add(new int[] { dist[nextV], nextV });
				}
			}
		}

		// 출력하기
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else {
				System.out.println(dist[i]);
			}
		}
	}
}
