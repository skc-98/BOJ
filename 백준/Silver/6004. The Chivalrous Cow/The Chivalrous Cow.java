import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 시작 좌표, 종료 좌표
		int sx = 0, sy = 0;
		int ex = 0, ey = 0;

		// 격자 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);

				// 시작 좌표 넣기
				if (d[i][j] == 'K') {
					sx = i;
					sy = j;
				}

				// 종료 좌표 넣기
				if (d[i][j] == 'H') {
					ex = i;
					ey = j;
				}
			}
		}

		// BFS 세팅
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[n][m];
		q.add(new int[] { sx, sy });
		visit[sx][sy] = 1;

		// BFS 시작
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 나이트 방향만큼
			int count = visit[x][y];
			for (int k = 0; k < 8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 검사, 방문(이하로) 검사, 장애물 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] != 0 || d[nx][ny] == '*')
					continue;

				// 다음 좌표 넣기
				q.add(new int[] { nx, ny });
				visit[nx][ny] = count + 1;
			}
		}

		// 답 출력하기
		System.out.print(visit[ex][ey] - 1);
	}
}
