import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기, 쓰레기 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int gar = Integer.parseInt(st.nextToken());

		// 쓰레기 위치 저장할 배열, 방문 배열 선언
		int[][] d = new int[n + 1][m + 1];
		int[][] visit = new int[n + 1][m + 1];

		// 방문배열 -1로 초기화
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visit[i], -1);
		}

		// 쓰레기 위치 입력
		for (int i = 0; i < gar; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			d[x][y] = 1;
		}

		// 답 저장할 변수
		int ans = 0;

		// BFS용 큐
		Queue<int[]> q = new ArrayDeque<>();

		// BFS를 통해 영역 크기 구하고 답 갱신
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 쓰레기가 위치하고 아직 방문하지 않은 경우만
				int count = 1;
				if (d[i][j] != 0 && visit[i][j] == -1) {
					visit[i][j] = 1;
					q.add(new int[] { i, j, visit[i][j] });
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						int cnt = q.peek()[2];
						q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							// 범위 초과 및 방문검사
							if (nx < 1 || nx > n || ny < 1 || ny > m || visit[nx][ny] != -1 || d[nx][ny] == 0)
								continue;

							// 아니면 큐에 추가하기
							count++;
							visit[nx][ny] = cnt + 1;
							q.add(new int[] { nx, ny, visit[nx][ny] });
						}
					}
				}
				// 영역 하나 크기 구하기
				ans = Math.max(count, ans);
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}