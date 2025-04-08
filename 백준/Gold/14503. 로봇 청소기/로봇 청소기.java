import java.util.*;
import java.io.*;

public class Main {
	// 4방, 순서에 맞게 넣었음
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	// 청소 상태를 관리하기 위한 방문배열
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 방의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visit = new boolean[n][m];

		// 로봇 청소기의 좌표, 바라보는 방향 입력
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		// 방의 상태를 저장할 배열
		int[][] d = new int[n][m];

		// 방의 상태 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				// 벽이면 방문처리 해버리기
				if (d[i][j] == 1)
					visit[i][j] = true;
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 현재 칸에서부터 계속
		while (true) {
			// 현재 칸 청소 처리
			if (!visit[x][y]) {
				visit[x][y] = true;
				ans++;
			}

			// 4방 청소 여부 탐색
			boolean check = false;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 범위 초과 검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				// 만약 아직 청소하지 않은 방이면
				if (!visit[nx][ny]) {
					check = true;
				}
			}

			// 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if (!check) {
				// 후진 방향
				int newDir = (dir + 2) % 4;

				// 후진 가능하면 후진
				if (d[x + dx[newDir]][y + dy[newDir]] != 1) {
					x = x + dx[newDir];
					y = y + dy[newDir];
				}
				// 멈추기
				else {
					break;
				}
			}
			// 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			else {
				// 반시계 방향으로 90도 회전
				dir -= 1;
				if (dir < 0)
					dir += 4;

				// 현재 바라보는 방향으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				if (d[x + dx[dir]][y + dy[dir]] == 0 && !visit[x + dx[dir]][y + dy[dir]]) {
					x += dx[dir];
					y += dy[dir];
				}
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
