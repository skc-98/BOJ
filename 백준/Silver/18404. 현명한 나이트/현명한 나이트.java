import java.util.*;
import java.io.*;

public class Main {
	// 나이트 이동 방향 벡터
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기, 상대편 말의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 격자 생성
		int[][] d = new int[n + 1][n + 1];

		// 현재 나이트의 위치
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// 상대 말의 위치
		int[][] targets = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
			targets[i][0] = a;
			targets[i][1] = b;
		}

		// BFS 세팅
		int[][] visit = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visit[i], -1);
		}
		visit[x][y] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });

		// BFS 시작
		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();

			for (int k = 0; k < 8; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				// 범위 검사, 방문 검사
				if (nx < 1 || ny < 1 || nx > n || ny > n || visit[nx][ny] != -1)
					continue;

				visit[nx][ny] = visit[cx][cy] + 1;
				q.add(new int[] { nx, ny });
			}
		}

		// 답 출력하기
		for (int i = 0; i < m; i++) {
			int a = targets[i][0];
			int b = targets[i][1];
			System.out.print(visit[a][b] + " ");
		}
	}
}
