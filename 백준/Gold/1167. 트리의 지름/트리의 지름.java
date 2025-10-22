import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n;
	static List<List<int[]>> li;
	static boolean[] visit;
	static int far = 0;
	static int farDist = 0;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 트리 정점의 개수
		n = Integer.parseInt(br.readLine());

		// 인접 리스트 생성
		li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 입력받기
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)
					break;
				int value = Integer.parseInt(st.nextToken());
				li.get(number).add(new int[] { to, value });
			}
		}

		// 1번 노드에서 DFS 탐색 시작
		visit = new boolean[n + 1];
		visit[1] = true;
		dfs(1, 0);

		// 가장 먼 노드에서 2단계 DFS
		farDist = 0;
		visit = new boolean[n + 1];
		visit[far] = true;
		dfs(far, farDist);

		// 답 출력하기
		System.out.println(farDist);
	}

	// DFS 메서드
	static void dfs(int node, int dist) {
		if (dist > farDist) {
			farDist = dist;
			far = node;
		}

		List<int[]> nowli = li.get(node);
		for (int i = 0; i < nowli.size(); i++) {
			int to = nowli.get(i)[0];
			int value = nowli.get(i)[1];
			if (!visit[to]) {
				visit[to] = true;
				dfs(to, dist + value);
			}
		}
	}
}
