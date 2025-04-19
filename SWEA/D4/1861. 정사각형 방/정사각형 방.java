import java.util.*;
import java.io.*;

public class Solution {
	// 이동 가능한 방향
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	// 방문 배열
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 방의 크기 n 입력
			int n = Integer.parseInt(br.readLine());

			// 방의 상태를 저장할 배열
			int[][] d = new int[n][n];

			// 방의 상태 입력
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 방문 배열 초기화
			visit = new boolean[n][n];

			// 답을 저장할 변수
			int ans = 0, roomNum = d[0][0];

			// BFS 탐색을 위한 큐
			Queue<int[]> q = new ArrayDeque<>();

			// (0,0)부터 모든 칸을 순서대로 돌면서 BFS 탐색을 통해 최댓값을 구하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 큐에 시작하는 방과 방의 수 1 넣기
					q.add(new int[] { i, j, 1 });

					// 큐가 빌때까지 BFS 탐색
					while (!q.isEmpty()) {
						// 큐의 맨 앞 요소 빼기
						int x = q.peek()[0];
						int y = q.peek()[1];
						int count = q.peek()[2];
						q.poll();

						// 4방향 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위 검사, 방문 검사
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
								continue;

							// 1더 큰 방이면 이동 가능, 큐에 추가하고 답 갱신여부 확인
							if (d[nx][ny] + 1 == d[x][y]) {
								// 현재 값이 지금까지 구한 답보다 크면
								if (count + 1 > ans) {
									ans = count + 1;
									roomNum = d[nx][ny];
								}

								// 만약 값이 같으면 방 번호가 더 작은 경우가 답임
								if (count + 1 == ans) {
									roomNum = Math.min(roomNum, d[nx][ny]);
								}

								// 큐에 다음 칸 넣기
								q.add(new int[] { nx, ny, count + 1 });
							}
						}
					}
				}
			}

			// 답 출력하기
			System.out.printf("#%d %d %d\n", tc, roomNum, ans);
		}
	}
}
