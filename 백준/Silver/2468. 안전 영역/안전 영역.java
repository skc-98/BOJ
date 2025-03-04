import java.util.*;
import java.io.*;

public class Main {
	// 탐색시 이동 방향
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int maxScore = 0;
	static int minScore = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n입력
		int n = Integer.parseInt(br.readLine());

		// n*n 공간의 정보 입력
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				if (d[i][j] > maxScore)
					maxScore = d[i][j];
				if (d[i][j] < minScore)
					minScore = d[i][j];
			}
		}
		// 입력까지 정상

		// 답을 저장할 변수
		int ans = 0;

		// 안전 영역의 개수 구하기
		for (int score = 0; score <= maxScore; score++) {
			// 기준 점수 기준으로 0, 1 배열로 변환
			int[][] area = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][j] <= score) {
						area[i][j] = 0;
					} else {
						area[i][j] = 1;
					}
				}
			}
			// 각 점수당 안전 배열로 변환은 완성

			// 해당 점수의 안전 배열 개수를 저장할 변수
			int safeCount = 0;

			// 이제 bfs 탐색으로 각 점수 당 안전 영역의 개수 구해서 최대값 구하기
			// 방문처리용 배열
			boolean[][] visit = new boolean[n][n];
			Queue<int[]> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 안전 영역이면서 방문하지 않은 경우
					if (area[i][j] == 1 && !visit[i][j]) {
						// 새로운 안전영역 찾았으니 안전 개수 증가
						safeCount++;

						// 큐에 해당 좌표 넣고 방문 처리
						q.add(new int[] { i, j });
						visit[i][j] = true;
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.peek()[1];
							q.poll();
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								// 범위 초과, 방문확인
								if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || area[nx][ny] == 0) {
									continue;
								}
								q.add(new int[] { nx, ny });
								visit[nx][ny] = true;
							}
						}
					}
				}
			}

			// 해당 점수의 안전 영역 수가 더 많으면 답 갱신
			ans = Math.max(ans, safeCount);
		}

		System.out.print(ans);
	}
}
