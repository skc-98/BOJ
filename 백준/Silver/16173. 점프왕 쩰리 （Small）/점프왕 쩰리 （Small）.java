import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른입출력을 위한 BufferedReader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 게임 구역의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 게임판 입력
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방문 배열과 큐 생성, 시작 좌표 삽입
		boolean[][] visit = new boolean[n][n];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		visit[0][0] = true;

		// BFS
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 도착 지점이면 승리
			if (d[x][y] == -1) {
				System.out.println("HaruHaru");
				return;
			}

			int jump = d[x][y];

			for (int k = 0; k < 2; k++) {
				int nx = x + dx[k] * jump;
				int ny = y + dy[k] * jump;

				// 범위 검사, 방문 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
					continue;

				// 다음 좌표 삽입
				visit[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}
		}

		// 도달 불가능한 경우
		System.out.println("Hing");
	}
}
