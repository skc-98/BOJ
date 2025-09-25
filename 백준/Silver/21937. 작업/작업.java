import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점 수, 간선 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 인접리스트 생성
		List<List<Integer>> li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li.get(b).add(a);
		}

		// 목표 작업
		int target = Integer.parseInt(br.readLine());

		// 정답 변수
		int ans = 0;

		// BFS용 큐, 방문배열
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n + 1];

		// 첫 원소 삽입
		q.add(target);
		visit[target] = true;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < li.get(now).size(); i++) {
				int next = li.get(now).get(i);
				if (!visit[next]) {
					visit[next] = true;
					q.add(next);
					ans++;
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
