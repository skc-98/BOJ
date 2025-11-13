import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n;
	static List<List<Integer>> li;
	static int count = 0;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 노드의 수
		n = Integer.parseInt(br.readLine());

		// 리스트 할당
		li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}
		visit = new boolean[n + 1];

		// 간선 정보 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li.get(a).add(b);
			li.get(b).add(a);
		}

		// DFS
		dfs(1, 0);

		// 경기 결과 출력
		if (count % 2 == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

	// DFS 메서드
	static void dfs(int now, int depth) {
		visit[now] = true;
		boolean isLeaf = true;

		// 다음 노드 탐색
		for (int i = 0; i < li.get(now).size(); i++) {
			if (visit[li.get(now).get(i)])
				continue;
			isLeaf = false;
			dfs(li.get(now).get(i), depth + 1);
		}

		// 리프 노드인 경우
		if (isLeaf) {
			count += depth;
		}
	}
}
