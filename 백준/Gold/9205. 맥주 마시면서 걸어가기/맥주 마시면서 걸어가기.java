import java.util.*;
import java.io.*;

// 모든 경우에 맥주는 20개를 가지고 시작, 50미터마다 무조건 하나를 마셔야함 ==> 편의점 없이 이동 가능한 거리 1000미터
// 편의점에 들렀을 경우 맥주는 20병으로 초기화가 가능함
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 편의점의 수 입력
			int n = Integer.parseInt(br.readLine());

			// 집의 좌표 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());

			// 편의점 좌표들 저장할 배열
			int[][] conv = new int[n][2];

			// 편의점의 좌표 n개 입력
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				conv[i][0] = Integer.parseInt(st.nextToken());
				conv[i][1] = Integer.parseInt(st.nextToken());
			}

			// 락 페스티벌 좌표 입력
			st = new StringTokenizer(br.readLine());
			int pentaX = Integer.parseInt(st.nextToken());
			int pentaY = Integer.parseInt(st.nextToken());

			// BFS 탐색을 위한 큐, 방문 배열
			boolean[] visit = new boolean[n];
			Queue<Integer> q = new ArrayDeque<>();

			// 시작점에서 바로 도착점으로 갈 수 있는 경우 처리
			int distance = manhatan(homeX, homeY, pentaX, pentaY);
			if (distance <= 1000) {
				System.out.println("happy");
				continue;
			}

			// 바로 못가는 경우 시작점에서 이동 가능한 모든 편의점 먼저 큐에 넣기
			for (int i = 0; i < n; i++) {
				distance = manhatan(homeX, homeY, conv[i][0], conv[i][1]);
				if (distance <= 1000) {
					q.add(i);
					visit[i] = true;
				}
			}

			boolean check = false;

			// 큐가 빌때까지 계속 BFS 탐색
			while (!q.isEmpty()) {
				// 큐 맨앞의 요소 꺼내기
				int num = q.poll();
				int x = conv[num][0];
				int y = conv[num][1];

				// 먼저 현재 점에서 펜타포트에 도착할 수 있는지 확인
				if (manhatan(x, y, pentaX, pentaY) <= 1000) {
					System.out.println("happy");
					check = true;
					break;
				}

				// 이제 현재 점에서 이동 가능한 모든 편의점 큐에 넣기
				for (int i = 0; i < n; i++) {
					// 자기 자신 제외, 방문 편의점 제외
					if (i == num || visit[i])
						continue;

					if (manhatan(x, y, conv[i][0], conv[i][1]) <= 1000) {
						q.add(i);
						visit[i] = true;
					}
				}
			}

			// 불가능한 경우 출력
			if (!check) {
				System.out.println("sad");
			}
		}
	}

	// 맨하탄 거리 구하는 메서드
	static int manhatan(int x, int y, int x2, int y2) {
		return Math.abs(x - x2) + Math.abs(y - y2);
	}
}
