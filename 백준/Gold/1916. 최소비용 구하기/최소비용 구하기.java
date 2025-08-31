import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시의 개수
		int n = Integer.parseInt(br.readLine());

		// 버스의 개수
		int m = Integer.parseInt(br.readLine());

		// 인접 리스트 생성
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 버스의 정보
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph.get(start).add(new int[] { end, value });
		}

		// 목표 도시 정보
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());

		// 거리 배열 생성
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[startCity] = 0;

		// 다익스트라를 위한 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] { startCity, 0 });

		// 다익스트라
		while (!pq.isEmpty()) {
			int now = pq.peek()[0];
			int cost = pq.peek()[1];
			pq.poll();

			// 갱신 안할 경우
			if (cost > dist[now])
				continue;

			// 갱신 한다면
			for (int[] next : graph.get(now)) {
				int nextCity = next[0];
				int nextCost = cost + next[1];
				if (nextCost < dist[nextCity]) {
					dist[nextCity] = nextCost;
					pq.add(new int[] { nextCity, nextCost });
				}
			}
		}

		// 답 출력하기
		System.out.print(dist[endCity]);
	}
}
