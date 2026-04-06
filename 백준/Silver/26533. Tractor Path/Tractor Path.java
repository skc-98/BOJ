import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기
		int n = Integer.parseInt(br.readLine());

		// 격자 입력
		char[][] d = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 시작 좌표 저장
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];
		q.add(new int[] { 0, 0 });
		visit[0][0] = true;

		// BFS
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 2방 탐색
			for (int k = 0; k < 2; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 검사, x 검사, 방문 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] != '.')
					continue;

				// 다음 좌표
				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
			}
		}

		// 답 출력하기
		if (visit[n - 1][n - 1]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
