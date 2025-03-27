import java.util.*;
import java.io.*;

// 아이디어: MST 크루스칼 풀이
public class Main {
	// 컴퓨터의 수, 선의 수
	static int v, e;

	// 간선 저장할 배열
	static Line[] lines;

	// 부모 노드 저장할 배열
	static int[] parent;

	// 배열 생성하는 메서드
	static void make() {
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}
	}

	// 부모 찾는 메서드
	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	// 합칠지 여부 결정하는 메서드
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB)
			return false;

		parent[rootB] = parent[rootA];
		return true;

	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터의 수, 선의 수 입력
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());

		// 간선 배열 생성
		lines = new Line[e];
		parent = new int[v + 1];

		// 집합 생성하기
		make();

		// 연결 가능한 선의 수 입력
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			lines[i] = new Line(from, to, weight);
		}

		// 간선 가중치 작은 순서로 정렬
		Arrays.sort(lines);

		// 답을 저장할 변수, 최적화를 위한 count
		long ans = 0;
		int count = 0;

		// 정렬된 간선이 루프를 만들지 않는 선에서 선택하기
		for (int i = 0; i < e; i++) {
			if (union(lines[i].from, lines[i].to)) {
				ans += lines[i].weight;
				count++;
			}
			if (count == v - 1)
				break;
		}

		// 답 출력하기
		System.out.println(ans);
	}
}

// 연결 가능한 선
class Line implements Comparable<Line> {
	int from, to, weight;

	public Line(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Line o) {
		return Integer.compare(this.weight, o.weight);
	}
}