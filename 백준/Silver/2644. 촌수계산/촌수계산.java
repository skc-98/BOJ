import java.util.*;
import java.io.*;

public class Main{
	// 사람의 수
	static int n;

	// 관계를 저장할 리스트
	static List<List<Integer>> relation;

	// 방문 처리용 배열
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수
		n = Integer.parseInt(br.readLine());

		// 찾아야 하는 관계
		StringTokenizer st = new StringTokenizer(br.readLine());
		int findA = Integer.parseInt(st.nextToken());
		int findB = Integer.parseInt(st.nextToken());

		// 관계를 저장할 인접 리스트
		relation = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			relation.add(new ArrayList<>());
		}

		// 주어지는 관계의 수
		int rel = Integer.parseInt(br.readLine());
		for (int i = 0; i < rel; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relation.get(a).add(b);
			relation.get(b).add(a);
		}

		// DFS 탐색을 통해 촌수 찾기
		visit = new boolean[n + 1];
		dfs(findA, findB, 0);

		// 여기까지 오면 불가능한 경우
		System.out.print(-1);
	}

	// DFS 탐색 메서드
	static void dfs(int a, int b, int depth) {
		// 촌수를 구하면 출력
		if (a == b) {
			System.out.print(depth);
			System.exit(0);
		}

		// 방문 처리
		visit[a] = true;

		// 다음 사람 계속해서 확인하기
		for (int i = 0; i < relation.get(a).size(); i++) {
			int next = relation.get(a).get(i);
			if (!visit[next]) {
				dfs(next, b, depth + 1);
			}
		}

		// 원상복구
		visit[a] = false;
	}
}
