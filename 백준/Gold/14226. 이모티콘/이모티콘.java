import java.util.*;
import java.io.*;

// 2차원 방문 배열을 만들어야 한다는게 키포인트
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 방문 배열, 큐
		boolean visit[][] = new boolean[2 * n + 1][2 * n + 1];
		Queue<int[]> q = new ArrayDeque<>();

		// 현재 화면, 클립보드, 연산 수
		int screen = 1;
		int clip = 0;
		int count = 0;
		visit[screen][clip] = true;
		q.add(new int[] { screen, clip, count });

		// BFS 시작
		while (true) {
			// 초기 값 빼기
			screen = q.peek()[0];
			clip = q.peek()[1];
			count = q.peek()[2];
			q.poll();

			// 조건 완료되었으면 답 출력하고 종료
			if (screen == n) {
				System.out.println(count);
				break;
			}

			// 1번 연산 진행
			if (!visit[screen][screen]) {
				visit[screen][screen] = true;
				q.add(new int[] { screen, screen, count + 1 });
			}

			// 2번 연산 진행
			if (clip > 0 && screen + clip <= 2 * n && !visit[screen + clip][clip]) {
				visit[screen + clip][clip] = true;
				q.add(new int[] { screen + clip, clip, count + 1 });
			}

			// 3번 연산 진행
			if (screen - 1 >= 0 && !visit[screen - 1][clip]) {
				visit[screen - 1][clip] = true;
				q.add(new int[] { screen - 1, clip, count + 1 });
			}
		}
	}
}
