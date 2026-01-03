import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 각 방들의 정보
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 비밀번호 찾기
		int ans = 0;

		// 전역 최장 최단거리
		int bestDist = -1;

		// 방문/거리 배열
		int[][] visit = new int[n][m];

		// 모든 시작 방에서 BFS
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 0이 적힌 방은 들어갈 수 없다.
				if (d[i][j] == 0) {
					continue;
				}
				for (int k = 0; k < n; k++) {
					Arrays.fill(visit[k], -1);
				}

				// BFS 준비
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.add(new int[] { i, j });
				visit[i][j] = 0;

				// 현재 시작점에서의 최장 거리 및 그때의 끝 방 숫자 최댓값
				int farDist = 0;
				int farMaxValue = d[i][j];

				// BFS 수행
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					int x = cur[0];
					int y = cur[1];

					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];

						// 범위 검사, 0 검사, 방문 검사
						if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] == 0 || visit[nx][ny] != -1) {
							continue;
						}

						// 다음 추가
						visit[nx][ny] = visit[x][y] + 1;
						q.add(new int[] { nx, ny });

						// 최장 거리 갱신
						if (visit[nx][ny] > farDist) {
							farDist = visit[nx][ny];
							farMaxValue = d[nx][ny];
						} else if (visit[nx][ny] == farDist) {
							if (d[nx][ny] > farMaxValue) {
								farMaxValue = d[nx][ny];
							}
						}
					}
				}

				// 시작 방과 끝 방에 적힌 숫자의 합
				int sum = d[i][j] + farMaxValue;

				// 최장 최단거리 우선으로 합이 최대
				if (farDist > bestDist) {
					bestDist = farDist;
					ans = sum;
				} else if (farDist == bestDist) {
					if (sum > ans) {
						ans = sum;
					}
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
