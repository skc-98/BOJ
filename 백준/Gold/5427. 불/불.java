import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 지도의 높이와 너비 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 지도의 상태를 저장할 배열
			char[][] d = new char[m][n];
			int[][] fire_time = new int[m][n];
			int[][] person_time = new int[m][n];
			Queue<int[]> fire_q = new ArrayDeque<>();
			Queue<int[]> person_q = new ArrayDeque<>();

			// 지도의 상태 입력, 사람과 불의 위치 저장
			for (int i = 0; i < m; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					d[i][j] = line.charAt(j);
					fire_time[i][j] = -1;
					person_time[i][j] = -1;
					if (d[i][j] == '*') {
						fire_q.add(new int[] { i, j });
						fire_time[i][j] = 0;
					}
					if (d[i][j] == '@') {
						person_q.add(new int[] { i, j });
						person_time[i][j] = 0;
					}
				}
			}

			// 불 먼저 확산
			while (!fire_q.isEmpty()) {
				int x = fire_q.peek()[0];
				int y = fire_q.peek()[1];
				fire_q.poll();
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					// 범위 초과 검사
					if (nx < 0 || nx >= m || ny < 0 || ny >= n)
						continue;

					// 벽이거나 방문했으면 건너뛰기
					if (d[nx][ny] == '#' || fire_time[nx][ny] != -1)
						continue;
					fire_time[nx][ny] = fire_time[x][y] + 1;
					fire_q.add(new int[] { nx, ny });
				}
			}

			// 사람 이동
			boolean escaped = false;
			int result = -1;
			while (!person_q.isEmpty()) {
				int x = person_q.peek()[0];
				int y = person_q.peek()[1];
				person_q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					// 탈출 성공
					if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
						result = person_time[x][y] + 1;
						escaped = true;
						break;
					}

					// 벽이거나 방문했으면 건너뛰기
					if (d[nx][ny] == '#' || person_time[nx][ny] != -1)
						continue;

					// 불이 붙은 지점이면 건너뛰기
					if (fire_time[nx][ny] != -1 && fire_time[nx][ny] <= person_time[x][y] + 1)
						continue;

					person_time[nx][ny] = person_time[x][y] + 1;
					person_q.add(new int[] { nx, ny });
				}
				if (escaped)
					break;
			}

			if (escaped) {
				System.out.println(result);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}
