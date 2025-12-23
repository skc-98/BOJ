import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 지도 상태 입력
		char[][] d = new char[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = st.nextToken().charAt(0);
			}
		}

		// 답 변수
		int ansMax = Integer.MIN_VALUE;
		int ansMin = Integer.MAX_VALUE;

		// BFS 세팅
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, d[0][0] - '0', 0 });

		// BFS 시작
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int val = cur[2];
			int op = cur[3];

			for (int k = 0; k < 2; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				// 연산자 칸
				if (d[nx][ny] == '+' || d[nx][ny] == '-' || d[nx][ny] == '*') {
					q.add(new int[] { nx, ny, val, d[nx][ny] });
				}
				// 숫자 칸
				else {
					int num = d[nx][ny] - '0';
					int nextVal = val;

					if (op == '+')
						nextVal = val + num;
					else if (op == '-')
						nextVal = val - num;
					else if (op == '*')
						nextVal = val * num;

					// 도착 지점
					if (nx == n - 1 && ny == n - 1) {
						ansMax = Math.max(ansMax, nextVal);
						ansMin = Math.min(ansMin, nextVal);
					} else {
						q.add(new int[] { nx, ny, nextVal, 0 });
					}
				}
			}
		}

		// 답 출력하기
		System.out.printf("%d %d", ansMax, ansMin);
	}
}
