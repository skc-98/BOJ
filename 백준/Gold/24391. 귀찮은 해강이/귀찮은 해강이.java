import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;

	// 집합 생성
	public static void make(int n) {
		parent = new int[n + 1];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	// 집합 합치기
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent[rootA] = rootB;
		}
	}

	// 부모 찾기
	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 강의의 수, 건물 쌍의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 집합 초기화
		make(n);

		// 건물 쌍의 정보 입력, 유니온 파인드 생성
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		// 답을 저장할 변수
		int ans = 0;

		// 시간표 정보 입력
		st = new StringTokenizer(br.readLine());
		int[] schedule = new int[n];
		for (int i = 0; i < n; i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}

		// 밖으로 나온 횟수 카운트
		for (int i = 1; i < n; i++) {
			if (find(schedule[i - 1]) != find(schedule[i])) {
				ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
