import java.util.*;
import java.io.*;

// 아이디어
// 연결 된 모든 간선 정보를 통해 MST를 구하고 가장 큰 비용 간선을 제외한 비용의 합을 구하면 답
// 크루스칼 알고리즘으로 풀었음
public class Main {
	// 집의 수, 길의 수
	static int n, m;

	// 각 정점의 부모 정보를 저장할 배열
	static int[] parents;

	// 집합 만드는 메서드
	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	// 각 연결 합치는 메서드
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parents[rootA] = rootB;
		}
	}

	// 각 정점의 부모 찾는 메서드
	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 수, 길의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 집합 생성하기, 인덱스 1번부터 사용
		parents = new int[n + 1];
		make();

		// 간선의 정보를 저장할 리스트
		List<int[]> edge = new ArrayList<>();

		// m개의 연결 관계 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge.add(new int[] { a, b, c });
		}

		// 간선을 비용 기준으로 정렬
		Collections.sort(edge, (a, b) -> Integer.compare(a[2], b[2]));

		// 답을 저장할 변수
		int ans = 0;

		// 간선을 순회하면서 MST 구성, 가장 비용이 큰 간선 찾기
		int maxCost = 0;
		for (int i = 0; i < edge.size(); i++) {
			if (find(edge.get(i)[0]) != find(edge.get(i)[1])) {
				union(edge.get(i)[0], edge.get(i)[1]);
				ans += edge.get(i)[2];
				maxCost = Math.max(maxCost, edge.get(i)[2]);
			}
		}

		// 답 출력하기
		System.out.println(ans - maxCost);
	}
}
