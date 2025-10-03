import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수
	static int ans = Integer.MAX_VALUE;
	static int[][] d;
	static List<CCTV> cctvs;
	static int n, m;

	// CCTV 클래스
	static class CCTV {
		int x, y, type;

		CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	// 4방향 벡터
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	// CCTV별 방향 경우의 수
	static int[][][] dirs = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
			{ { 0, 1, 2, 3 } } };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사무실의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 사무실 배열, CCTV 리스트 생성
		d = new int[n][m];
		cctvs = new ArrayList<>();

		// 사무실 상태 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				if (d[i][j] >= 1 && d[i][j] <= 5) {
					cctvs.add(new CCTV(i, j, d[i][j]));
				}
			}
		}

		// DFS 호출
		dfs(0, d);

		// 답 출력하기
		System.out.print(ans);
	}

	// 조합 메서드
	static void dfs(int idx, int[][] office) {
		if (idx == cctvs.size()) {
			ans = Math.min(ans, countBlind(office));
			return;
		}

		CCTV c = cctvs.get(idx);

		for (int[] dirSet : dirs[c.type]) {
			int[][] copied = new int[n][m];
			for (int i = 0; i < n; i++)
				copied[i] = office[i].clone();

			// 감시 표시
			for (int dir : dirSet) {
				watch(copied, c.x, c.y, dir);
			}

			// 다음 CCTV
			dfs(idx + 1, copied);
		}
	}

	// 특정 방향 감시
	static void watch(int[][] office, int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
			if (office[nx][ny] == 6)
				break;
			if (office[nx][ny] == 0)
				office[nx][ny] = -1;
			nx += dx[dir];
			ny += dy[dir];
		}
	}

	// 사각지대 수 구하는 메서드
	static int countBlind(int[][] office) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (office[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}