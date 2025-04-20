import java.util.*;
import java.io.*;

// 테스트케이스가 10개로 고정
// 방향 비순환 그래프니까 위상 정렬을 통해 해결 할 수 있음
public class Solution {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 10회 반복
		for (int tc = 1; tc <= 10; tc++) {
			// 정점의 수, 간선의 수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			// 진입 차수 배열 생성, 인덱스는 1번부터
			int[] degree = new int[v + 1];

			// 인접 리스트 생성
			List<Integer>[] graph = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}

			// 간선의 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				// 연결 정보 입력
				graph[from].add(to);

				// 진입 차수 증가
				degree[to]++;
			}

			// 위상 정렬을 위한 큐
			Queue<Integer> q = new ArrayDeque<>();

			// 진입 차수가 0인 정점 큐에 삽입
			for (int i = 1; i <= v; i++) {
				if (degree[i] == 0) {
					q.add(i);
				}
			}

			// 답을 저장할 리스트
			List<Integer> ans = new ArrayList<>();

			// 큐가 빌때까지 반복
			while (!q.isEmpty()) {
				int now = q.poll();
				ans.add(now);

				// 연결 된 정점 진입 차수 감소시키기
				for (int i = 0; i < graph[now].size(); i++) {
					int next = graph[now].get(i);
					degree[next]--;

					// 진입 차수 0인 정점 다시 추가
					if (degree[graph[now].get(i)] == 0) {
						q.add(next);
					}
				}
			}

			// 답 출력하기
			System.out.printf("#%d ", tc);
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
			System.out.println();
		}
	}
}
