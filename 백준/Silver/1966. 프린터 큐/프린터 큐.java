import java.util.*;
import java.io.*;

// 아이디어
// 큐와 우선순위 큐를 사용해 현재 출력할 문서가 가장 높은 우선순위를 가지는지 판단하고
// 아니라면 문제 요구대로 뒤로 이동시키는 시뮬레이션 방식을 사용했습니다.
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 문서의 개수 입력, 찾는 문서의 위치 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int pointer = Integer.parseInt(st.nextToken());

			// 문서의 중요도를 관리할 큐
			Queue<int[]> q = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			// n개 문서의 중요도 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int important = Integer.parseInt(st.nextToken());
				// 목표하는 문서인지 아닌지 확인해서 1로 표시
				if (i == pointer)
					q.add(new int[] { important, 1 });
				else
					q.add(new int[] { important, 0 });
				// 우선순위 큐에 넣어서 중요도를 내림차순으로 정렬
				pq.add(important);
			}

			// 답을 저장할 변수
			int ans = 0;
			while (true) {
				// 현재 맨 앞 문서가 가장 높은 우선순위면 바로 출력
				if (pq.peek() == q.peek()[0]) {
					// 출력 순서 증가
					ans++;

					// 목표하던 문서면 종료
					if (q.peek()[1] == 1) {
						break;
					}

					// 출력했으니까 큐에서 빼기
					pq.poll();
					q.poll();
				}
				// 일치하지 않으면 더 높은 우선순위 문서가 남은거임
				else {
					// 그대로 다시 뒤로 넣기
					q.add(new int[] { q.peek()[0], q.peek()[1] });
					q.poll();
				}
			}

			// 답 출력하기
			System.out.println(ans);
		}
	}
}