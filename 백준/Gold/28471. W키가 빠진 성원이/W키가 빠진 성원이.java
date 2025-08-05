import java.util.*;
import java.io.*;

public class Main {
	// 7방향 벡터
	static int[] dx = { -1, -1, 0, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 맵 상태 저장할 배열
		char[][] d = new char[n][n];

		// 종료 지점 좌표
		int fx = 0, fy = 0;

		// 배열 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
				if (d[i][j] == 'F') {
					fx = i;
					fy = j;
				}
			}
		}

		// 답
		int ans = 0;

		// BFS용 큐, 방문배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];

		// 종료 지점 기준으로 BFS 한번 돌리기
		q.add(new int[] { fx, fy });
		visit[fx][fy] = true;
		while (!q.isEmpty()) {
			// 첫 요소 빼기
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 7방 탐색
			for (int k = 0; k < 7; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 방문 체크, 범위 체크, 벽 체크
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] == '#')
					continue;

				// 아니면 '.'인지 확인하고 큐에 삽입 및 답 증가
				if (d[nx][ny] == '.') {
					ans++;
					q.add(new int[] { nx, ny });
					visit[nx][ny] = true;
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
