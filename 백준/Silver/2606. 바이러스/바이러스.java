import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언
	static List<Integer>[] list;
	static Set<Integer> pc;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 연결된 컴퓨터 쌍의 수
		int pair = Integer.parseInt(br.readLine());

		// 연결 정보 저장할 인접 리스트 생성
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 인접 리스트에 연결 정보 입력하기
		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		// 바이러스에 걸리는 컴퓨터를 저장할 set
		pc = new HashSet<>();

		// 1번 컴퓨터 기준으로 DFS 탐색 시작
		for (int i = 0; i < list[1].size(); i++) {
			int now = list[1].get(i);
			dfs(now);
		}

		// 답은 set의 크기임
		System.out.println(pc.size());
	}

	// DFS 탐색 메서드
	static void dfs(int now) {
		// 이미 방문한 경우 더 들어가지 않기
		if (pc.contains(now) || now == 1)
			return;
		pc.add(now);

		// 아직 방문하지 않은 경우에만 DFS 재호출
		for (int next : list[now]) {
			if (!pc.contains(next))
				dfs(next);
		}
	}
}
