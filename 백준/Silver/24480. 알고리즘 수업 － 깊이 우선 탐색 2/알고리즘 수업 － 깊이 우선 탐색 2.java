import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n, m, start;
	static List<List<Integer>> li;
	static int[] visit;
	static int count = 1;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점 수, 간선 수, 시작 정점 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		// 방문 배열 생성
		visit = new int[n + 1];

		// 인접 리스트 생성
		li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			li.get(from).add(to);
			li.get(to).add(from);
		}

		// 리스트 역순 정렬
		for (int i = 0; i <= n; i++) {
			Collections.sort(li.get(i), Collections.reverseOrder());
		}

		// DFS 시작
		dfs(start);

		// 출력
		for (int i = 1; i <= n; i++) {
			System.out.println(visit[i]);
		}
	}

	// DFS 메서드
	static void dfs(int n) {
		visit[n] = count++;

		// DFS 탐색
		for (int i = 0; i < li.get(n).size(); i++) {
			if (visit[li.get(n).get(i)] == 0) {
				dfs(li.get(n).get(i));
			}
		}
		return;
	}
}
