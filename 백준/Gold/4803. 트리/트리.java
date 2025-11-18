import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수
	static int n, m;
	static List<List<Integer>> li;
	static boolean[] visit;
	static int count;
	static int vertexCount;
	static int edgeCount;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 번호
		int tc = 0;

		// 종료시까지 반복
		while (true) {
			// 트리의 수 초기화, 테케번호 증가
			count = 0;
			tc++;

			// 정점의 수, 간선의 수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 종료 조건
			if (n == 0 && m == 0)
				break;

			// 인접 리스트 생성
			li = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				li.add(new ArrayList<>());
			}
			visit = new boolean[n + 1];

			// 간선 정보 입력
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				li.get(a).add(b);
				li.get(b).add(a);
			}

			// DFS 돌리면서 트리의 수 세기
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {
					vertexCount = 0;
					edgeCount = 0;

					dfs(i);

					edgeCount /= 2;
					if (edgeCount == vertexCount - 1) {
						count++;
					}
				}
			}

			// 답 출력하기
			System.out.print("Case " + tc + ": ");
			if (count == 0) {
				System.out.println("No trees.");
			} else if (count == 1) {
				System.out.println("There is one tree.");
			} else {
				System.out.printf("A forest of %d trees.\n", count);
			}
		}
	}

	// DFS 메서드
	static void dfs(int now) {
		visit[now] = true;
		vertexCount++;

		for (int next : li.get(now)) {
			edgeCount++;

			if (!visit[next]) {
				dfs(next);
			}
		}
	}
}
