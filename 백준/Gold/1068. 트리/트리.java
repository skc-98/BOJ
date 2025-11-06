import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언부
	static int n;
	static List<List<Integer>> li;
	static int root;
	static int target;
	static int ans = 0;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 노드의 수 입력
		n = Integer.parseInt(br.readLine());

		// 인접 리스트 할당, 방문 배열 초기화
		li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			li.add(new ArrayList<>());
		}
		visit = new boolean[n];

		// 각 노드의 부모 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
				continue;
			}
			li.get(parent).add(i);
		}

		// 지울 노드 입력
		target = Integer.parseInt(br.readLine());

		// 루트 노드를 지운 경우
		if (target == root) {
			System.out.println(0);
		}
		// 일반적인 경우
		else {
			dfs(root);
			System.out.println(ans);
		}
	}

	// DFS 메서드
	static void dfs(int node) {
		// 이미 방문한 노드 건너 뛰기
		if (visit[node])
			return;

		// 현재 노드가 지울 노드인 경우 건너 뛰기
		if (node == target) {
			return;
		}

		visit[node] = true;

		// 다음 노드로 DFS
		int child = 0;
		for (int i = 0; i < li.get(node).size(); i++) {
			if (li.get(node).get(i) == target) {
				continue;
			}
			child++;
			dfs(li.get(node).get(i));
		}

		// 리프 노드인 경우 답 증가
		if (child == 0)
			ans++;
	}
}
