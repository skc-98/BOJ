import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 헛간의 수, 길의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 인접 리스트 생성
		List<List<Integer>> li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 길 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			li.get(start).add(end);
			li.get(end).add(start);
		}

		// 방문 배열, 큐
		int[] visit = new int[n + 1];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 1, 0 });
		visit[1] = 0;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			int now = q.peek()[0];
			int depth = q.peek()[1];
			q.poll();
			for (int i = 0; i < li.get(now).size(); i++) {
				int next = li.get(now).get(i);
				if (visit[next] != 0 || next == 1)
					continue;
				visit[next] = depth + 1;
				q.add(new int[] { next, depth + 1 });
			}
		}

		// 답 변수
		int ansIdx = Integer.MAX_VALUE;
		int ans = 0;
		int ansCount = 0;

		// 최대 중 최소 찾기
		for (int i = 1; i <= n; i++) {
			if (ans < visit[i]) {
				ansIdx = i;
				ans = visit[i];
				ansCount = 1;
			} else if (ans == visit[i]) {
				ansIdx = Math.min(ansIdx, i);
				ansCount++;
			}
		}

		// 답 출력
		System.out.print(ansIdx + " " + ans + " " + ansCount);
	}
}
