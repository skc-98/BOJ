import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// BFS 세팅
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[n][m];

		// 도착점 좌표
		int ex = 0, ey = 0;

		// 상태 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);

				// 시작점 넣기
				if (d[i][j] == 'K') {
					q.add(new int[] { i, j });
					visit[i][j] = 1;
				}

				// 끝점
				if (d[i][j] == 'X') {
					ex = i;
					ey = j;
				}
			}
		}

		// BFS 돌리기
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 8방 탐색
			for (int k = 0; k < 8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 검사, 장애물 검사, 방문 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] != 0 || d[nx][ny] == '#') {
					continue;
				}

				q.add(new int[] { nx, ny });
				visit[nx][ny] = visit[x][y] + 1;
			}
		}

		// 답 출력하기
		System.out.println(visit[ex][ey] - 1);
	}
}
