import java.util.*;
import java.io.*;

// DFS 재귀 다는 조건이 좀 이상한 듯;
public class Main {
	// 전역변수 선언부
	static int n, m;
	static int[][] d;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 노드 수, 노드 쌍의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 인접 행렬 할당
		d = new int[n + 1][n + 1];

		// 노드 연결 입력
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			d[start][end] = value;
			d[end][start] = value;
		}

		// 찾을 노드 쌍 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visit = new boolean[n + 1];
			int ans = dfs(a, b, 0);
			System.out.println(ans);
		}
	}

	// 방문 배열 처리
	static boolean[] visit;

	// DFS 메서드
	static int dfs(int start, int target, int diff) {
		// 접근 성공하면 거리 반환
		if (start == target) {
			return diff;
		}

		visit[start] = true;

		// 현재 노드에서 연결된 다음 노드로 진행
		for (int i = 1; i <= n; i++) {
			if (d[start][i] != 0 && !visit[i]) {
				int result = dfs(i, target, diff + d[start][i]);
				if (result != -1) {
					return result;
				}
			}
		}
		return -1;
	}
}
