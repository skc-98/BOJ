import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시의 수, 도로의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// n번까지 인접 리스트 생성
		List<List<Integer>> li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 도로 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			li.get(from).add(to);
			li.get(to).add(from);
		}

		// 도로 정비 계획의 도로 수 입력
		int road = Integer.parseInt(br.readLine());

		// 도로 만들면서 출력
		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			li.get(from).add(to);
			li.get(to).add(from);

			// BFS 세팅
			int[] visit = new int[n + 1];
			Arrays.fill(visit, -1);
			visit[1] = 0;
			Queue<Integer> q = new ArrayDeque<>();
			q.add(1);

			// BFS
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int j = 0; j < li.get(now).size(); j++) {
					int next = li.get(now).get(j);
					if (visit[next] != -1) {
						continue;
					}
					visit[next] = visit[now] + 1;
					q.add(next);
				}
			}

			// 답 출력하기
			for (int j = 1; j <= n; j++) {
				System.out.print(visit[j] + " ");
			}
			System.out.println();
		}
	}
}
