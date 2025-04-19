import java.util.*;
import java.io.*;

// 미로의 시작점은 항상 (1,1)이고 (n,m)으로 이동하는 경로 찾는거임
public class Main {
	// 이동 가능한 4 방향
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 미로의 크기 N과 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 미로의 상태 저장할 배열
		char[][] d = new char[n][m];

		// 미로의 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// BFS 탐색을 위한 큐, 방문 배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];

		// 큐에 시작점 넣고 방문처리
		q.add(new int[] { 0, 0, 1 });
		visit[0][0] = true;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			// 큐의 맨 앞 요소 꺼내기
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dist = q.peek()[2];
			q.poll();

			// 도착 지점이면 답 저장 후 종료
			if (x == n - 1 && y == m - 1) {
				ans = dist;
				break;
			}

			// 4 방향 탐색
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 검사, 방문 검사, 이동 가능 여부 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || d[nx][ny] == '0')
					continue;

				// 이동 가능하니까 큐에 추가하고 방문 처리
				q.add(new int[] { nx, ny, dist + 1 });
				visit[nx][ny] = true;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
