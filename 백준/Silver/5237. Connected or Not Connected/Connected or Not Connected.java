import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n, link;
	static List<List<Integer>> graph;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 장소랑 연결의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			link = Integer.parseInt(st.nextToken());

			// 인접 리스트 생성
			graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<>());
			}

			// 연결 입력
			for (int i = 0; i < link; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				// 양방향 삽입
				graph.get(from).add(to);
				graph.get(to).add(from);
			}

			visit = new boolean[n];

			// DFS
			dfs(0);

			// 연결 여부 확인
			boolean connect = true;
			for (int i = 0; i < n; i++) {
				if (!visit[i]) {
					connect = false;
					break;
				}
			}

			// 답 출력하기
			if (connect) {
				System.out.println("Connected.");
			} else {
				System.out.println("Not connected.");
			}

		}
	}

	// DFS
	static void dfs(int n) {
		visit[n] = true;
		for (int i = 0; i < graph.get(n).size(); i++) {
			int next = graph.get(n).get(i);
			if (!visit[next]) {
				dfs(next);
			}
		}
	}
}
