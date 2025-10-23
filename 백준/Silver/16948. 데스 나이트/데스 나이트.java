import java.util.*;
import java.io.*;

public class Main {
	// 나이트 이동
	static int[] dx = { -2, -2, 0, 0, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 체스판 크기
		int n = Integer.parseInt(br.readLine());

		// 체스판 생성
		int[][] d = new int[n][n];

		// 시작좌표, 목표좌표 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int tx = Integer.parseInt(st.nextToken());
		int ty = Integer.parseInt(st.nextToken());

		// BFS용 큐, 방문배열, 첫 원소 넣기
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], -1);
		}
		q.add(new int[] { sx, sy });
		visit[sx][sy] = 0;

		// BFS 시작
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 나이트 이동
			for (int k = 0; k < 6; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] != -1) {
					continue;
				}

				// 더 효율적인 이동이 있으면 거르기
				if (visit[nx][ny] != -1 && visit[nx][ny] < visit[x][y] + 1)
					continue;

				// 이동하기
				q.add(new int[] { nx, ny });
				visit[nx][ny] = visit[x][y] + 1;
			}
		}

		// 답 출력하기
		System.out.println(visit[tx][ty]);
	}
}
