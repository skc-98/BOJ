import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 레지스터 초기 값, 최종 값 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 방문 배열, 이전에 사용된 명령어를 순차적으로 더해 저장하기
			String[] visit = new String[10000];

			// BFS 탐색을 위한 큐
			Queue<Integer> q = new ArrayDeque<>();

			// 큐에 초기값 넣기
			q.add(n);
			visit[n] = "";

			// BFS 탐색 시작
			while (!q.isEmpty()) {
				int now = q.poll();

				// 목표 숫자에 도달하면 종료
				if (now == m)
					break;

				// D 연산
				int d = (now * 2) % 10000;
				if (visit[d] == null) {
					q.add(d);
					visit[d] = visit[now] + "D";
				}

				// S 연산
				int s;
				if (now == 0)
					s = 9999;
				else
					s = now - 1;
				if (visit[s] == null) {
					q.add(s);
					visit[s] = visit[now] + "S";
				}

				// L 연산
				int l = (now % 1000) * 10 + now / 1000;
				if (visit[l] == null) {
					q.add(l);
					visit[l] = visit[now] + "L";
				}

				// R 연산
				int r = (now % 10) * 1000 + now / 10;
				if (visit[r] == null) {
					q.add(r);
					visit[r] = visit[now] + "R";
				}
			}

			// 답 출력하기
			System.out.println(visit[m]);
		}
	}
}
