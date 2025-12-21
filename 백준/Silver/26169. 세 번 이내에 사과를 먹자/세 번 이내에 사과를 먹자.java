import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 전역 변수 선언부
	static int[][] d;
	static int x, y;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드 입력
		d = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 학생의 현재 위치 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		// DFS
		dfs(x, y, 0, 0);

		// 결과 출력
		System.out.println(answer);
	}

	// DFS 탐색
	static void dfs(int x, int y, int move, int apple) {
		// 이미 답을 찾았으면 더 볼 필요 없음
		if (answer == 1) {
			return;
		}

		// 사과를 2개 이상 먹었으면 성공
		if (apple >= 2) {
			answer = 1;
			return;
		}

		// 이동 횟수 3번 초과하면 종료
		if (move == 3) {
			return;
		}

		// 4방향 탐색
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			// 범위 검사, 장애물 검사
			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || d[nx][ny] == -1) {
				continue;
			}

			// 현재 칸 저장, 현재 위치 장애물로 변경
			int temp = d[nx][ny];
			d[x][y] = -1;

			// 사과 먹었는지 판단
			if (temp == 1) {
				dfs(nx, ny, move + 1, apple + 1);
			} else {
				dfs(nx, ny, move + 1, apple);
			}
			d[x][y] = 0;
		}
	}
}
