import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 전역 변수 선언
	static int[][] d;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 생성
		d = new int[5][5];

		// 격자 입력
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 시작점에서 DFS
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result[0] = d[i][j];
				dfs(i, j, 1);
			}
		}

		// 답 출력하기
		System.out.println(set.size());
	}

	static int[] result = new int[6];

	// DFS 메서드
	static void dfs(int x, int y, int depth) {
		// 6개 완성시
		if (depth == 6) {
			String ans = "";
			for (int i = 0; i < 6; i++) {
				ans += result[i];
			}
			set.add(ans);
			return;
		}

		// 4방 이동
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
				continue;

			result[depth] = d[nx][ny];
			dfs(nx, ny, depth + 1);
		}
	}
}
