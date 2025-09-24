import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언부
	static int n, m;
	static List<List<Integer>> li;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 동그라미 수, 직선 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// 인접 리스트
			li = new ArrayList<List<Integer>>();
			for (int i = 0; i <= n; i++) {
				li.add(new ArrayList<Integer>());
			}

			// 직선 입력
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				li.get(from).add(to);
				li.get(to).add(from);
			}

			// 색상 배열
			int[] color = new int[n + 1];

			// 답 변수
			boolean ans = false;

			// 모든 노드를 시작점으로 잡고
			for (int i = 1; i <= n; i++) {
				if (ans)
					break;
				if (color[i] != 0)
					continue;
				Queue<Integer> q = new ArrayDeque<>();
				q.add(i);
				color[i] = 1;
				while (!q.isEmpty()) {
					if (ans)
						break;
					int now = q.poll();
					int nowColor = color[now];
					for (int j = 0; j < li.get(now).size(); j++) {
						int next = li.get(now).get(j);
						if (color[next] != 0 && color[next] == nowColor) {
							ans = true;
							break;
						}
						if (color[next] != 0)
							continue;
						q.add(next);
						if (color[now] == 1)
							color[next] = 2;
						else
							color[next] = 1;
					}
				}
			}

			// 답 출력하기
			if (ans) {
				System.out.println("impossible");
			} else {
				System.out.println("possible");
			}
		}
	}
}
