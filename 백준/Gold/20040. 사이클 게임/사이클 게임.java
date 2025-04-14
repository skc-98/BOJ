import java.util.*;
import java.io.*;

public class Main {
	// 점의 개수, 차례의 수
	static int n, m;

	// 부모 정보를 저장할 배열
	static int[] parents;

	// 집합 생성하는 메서드
	static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	// 집합 합치는 메서드
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		// 부모가 같으면 사이클임
		if (rootA == rootB)
			return true;

		// 부모 바꿔서 합치기
		parents[rootB] = rootA;
		return false;
	}

	// 부모를 찾는 메서드
	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 점의 수, 차례의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 집합 생성, 인덱스 0번부터
		parents = new int[n];
		make();

		// 게임 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 사이클 여부 판단하고 사이클 생성시 답 출력
			if (union(a, b)) {
				System.out.print(i + 1);
				System.exit(0);
			}
		}

		// 여기까지 오면 사이클 없음
		System.out.println(0);
	}
}
