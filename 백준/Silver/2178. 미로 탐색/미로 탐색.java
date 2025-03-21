import java.util.*;
import java.io.*;

public class Main {
	// 이동 가능한 4 방향
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 맵의 상태를 저장할 배열
		char[][] d = new char[n][m];

		// 방문 처리할 배열
		boolean[][] visit = new boolean[n][m];

		// 맵의 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}
		// 답을 저장할 변수
		int ans = 0;

		// 큐에 시작점 삽입
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0 });
		visit[0][0] = true;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			// 큐의 맨 앞 요소 빼기
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			q.poll();

			// 목표하는 지점에 도착하면 출력하고 종료
			if (x == n - 1 && y == m - 1) {
				System.out.println(cnt + 1);
				return;
			}

			// 4방향 탐색
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 초과, 방문체크,
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] == '0')
					continue;

				// 다음 좌표 큐에 넣기
				q.add(new int[] { nx, ny, cnt + 1 });
				visit[nx][ny] = true;
			}
		}
	}
}
