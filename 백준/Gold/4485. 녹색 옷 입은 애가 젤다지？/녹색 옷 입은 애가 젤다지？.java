import java.util.*;
import java.io.*;

// 아이디어
// 시작점에서 목표 지점까지의 최소 거리를 구하는 문제이기 때문에 다익스트라 알고리즘을 통해 해결할 수 있습니다.

// 풀이과정
// 

public class Main {
	// 이동 가능한 방향
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 번호
		int tc = 0;

		// n 입력으로 0이 들어올때까지 반복
		while (true) {
			// tc증가
			tc++;

			// 동굴의 크기 n 입력
			int n = Integer.parseInt(br.readLine());
			// 0이 입력되면 종료
			if (n == 0)
				break;

			// n*n 동굴의 각 칸에 있는 도둑루피의 크기 입력
			int[][] d = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 값을 누적할 배열, 최댓값으로 초기화
			int[][] value = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(value[i], Integer.MAX_VALUE);
			}

			// 다익스트라를 위한 우선순위 큐, 비용을 기준으로 힙을 구성(Min-Heap)
			// Java의 PriorityQueue는 기본적으로 Min-Heap
			// Java에서 PriorityQueue 사용 방법 따로 공부하기
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

			// 큐에 시작점 추가하고 시작점 값 갱신
			pq.add(new int[] { d[0][0], 0, 0 });
			value[0][0] = d[0][0];

			// 다익스트라 시작
			while (!pq.isEmpty()) {
				// 맨 앞 요소 빼기
				int val = pq.peek()[0];
				int x = pq.peek()[1];
				int y = pq.peek()[2];
				pq.poll();

				// 현재 비용이 기존 비용보다 크면 건너뛰기
				if (val > value[x][y])
					continue;

				// 4방향 탐색
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위초과 검사
					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					// 다음 비용 계산
					int nextValue = val + d[nx][ny];

					// 더 적은 비용으로 갈 수 있으면 갱신하고 큐에 넣기
					if (nextValue < value[nx][ny]) {
						value[nx][ny] = nextValue;
						pq.add(new int[] { nextValue, nx, ny });
					}
				}
			}

			// 답 출력하기
			System.out.printf("Problem %d: %d\n", tc, value[n - 1][n - 1]);
		}
	}
}
