import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// BFS 세팅
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[n][m];

		// 격자 상태 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);

				// 시작점 저장
				if (d[i][j] == '2') {
					q.add(new int[] { i, j });
					visit[i][j] = 1;
				}
			}
		}

		// BFS 탐색
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 검사, 장애물 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] == '1' || visit[nx][ny] != 0) {
					continue;
				}

				// 가장 먼저 도착한 음식
				if (d[nx][ny] == '3' || d[nx][ny] == '4' || d[nx][ny] == '5') {
					System.out.println("TAK");
					System.out.println(visit[x][y]);
					return;
				}

				q.add(new int[] { nx, ny });
				visit[nx][ny] = visit[x][y] + 1;
			}
		}

		// 여기까지 오면 불가능
		System.out.println("NIE");
	}
}
