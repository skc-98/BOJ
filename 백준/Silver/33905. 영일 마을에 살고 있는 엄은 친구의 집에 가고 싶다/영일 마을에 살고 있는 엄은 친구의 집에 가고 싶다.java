import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수
	static int n, m, leave;
	static List<List<Integer>> li;
	static Set<Integer> remove;
	static int ans = 0;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 친구의 수, 도로의 수, 여행을 떠난 친구의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		leave = Integer.parseInt(st.nextToken());

		// 인접 리스트 생성
		li = new ArrayList<>();
		for (int i = 0; i <= n + 1; i++) {
			li.add(new ArrayList<>());
		}
		visit = new boolean[n + 2];

		// 도로 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			li.get(from).add(to);
			li.get(to).add(from);
		}

		// 여행을 떠난 친구 정보
		remove = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			remove.add(a);
		}

		// 1번부터 DFS
		visit[1] = true;
		dfs(1);

		// 답 출력하기
		System.out.print(ans);
	}

	// DFS 메서드
	static void dfs(int now) {
		for (int i = 0; i < li.get(now).size(); i++) {
			int next = li.get(now).get(i);

			// 여행을 떠난 녀석이면 넘기기
			if (remove.contains(next) || visit[next])
				continue;

			// 아니라면 방문 처리 후 답 증가
			visit[next] = true;
			ans++;
			dfs(next);
		}
	}
}
