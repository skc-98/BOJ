import java.util.*;
import java.io.*;

// 사다리는 올라가고 뱀은 내려온다는것 주의
public class Main {
	// 게임판
	static int[] d = new int[101];

	// 사다리와 뱀은 맵으로 관리
	static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 답 변수
		int ans = Integer.MAX_VALUE;

		// 사다리의 수 뱀의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 사다리 입력 => 1
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			d[start] = 1;
			ladder.put(start, end);
		}

		// 뱀 입력 => 2
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			d[start] = 2;
			snake.put(start, end);
		}

		// 방문 배열로 횟수도 처리
		int[] visit = new int[101];
		Arrays.fill(visit, Integer.MAX_VALUE);

		// 시작점에서부터 BFS 탐색 시작
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 1, 0 });
		visit[1] = 0;
		while (!q.isEmpty()) {
			int now = q.peek()[0];
			int cnt = q.peek()[1];
			q.poll();

			// 주사위 굴리기
			for (int k = 1; k <= 6; k++) {
				int next = now + k;

				// 범위 검사
				if (next > 100)
					continue;

				// 사다리/뱀 처리
				if (ladder.containsKey(next))
					next = ladder.get(next);
				if (snake.containsKey(next))
					next = snake.get(next);

				// 더 작은 경우만 추가
				if (visit[next] > cnt + 1) {
					q.add(new int[] { next, cnt + 1 });
					visit[next] = cnt + 1;
				}
			}
		}

		// 답 출력하기
		System.out.println(visit[100]);
	}
}
