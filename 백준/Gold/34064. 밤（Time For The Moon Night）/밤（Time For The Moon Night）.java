import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기, 별의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int star = Integer.parseInt(st.nextToken());

		// 격자 생성
		int[][] d = new int[n + 1][m + 1];

		// 별 입력받기
		for (int i = 0; i < star; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			d[x][y] = 1;
		}

		// 나의 구역
		st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());

		// 너의 구역
		st = new StringTokenizer(br.readLine());
		int a3 = Integer.parseInt(st.nextToken());
		int b3 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a4 = Integer.parseInt(st.nextToken());
		int b4 = Integer.parseInt(st.nextToken());

		// 답 변수
		long ans = 0;

		// 각 칸의 구역 변호 나누기
		int[][] comp = new int[n + 1][m + 1];
		int compId = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (d[i][j] == 0 && comp[i][j] == 0) {
					compId++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					comp[i][j] = compId;

					// BFS 시작
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = cur[0] + dx[k];
							int ny = cur[1] + dy[k];
							if (nx < 1 || ny < 1 || nx > n || ny > m)
								continue;
							if (d[nx][ny] == 1 || comp[nx][ny] != 0)
								continue;
							comp[nx][ny] = compId;
							q.add(new int[] { nx, ny });
						}
					}
				}
			}
		}

		// 각 구역별로 시작 가능한 칸의 수 세기
		long[] cntA = new long[compId + 1];
		long[] cntB = new long[compId + 1];

		// 나의 구역
		for (int i = a1; i <= a2; i++) {
			for (int j = b1; j <= b2; j++) {
				if (d[i][j] == 0 && comp[i][j] != 0) {
					cntA[comp[i][j]]++;
				}
			}
		}

		// 너의 구역
		for (int i = a3; i <= a4; i++) {
			for (int j = b3; j <= b4; j++) {
				if (d[i][j] == 0 && comp[i][j] != 0) {
					cntB[comp[i][j]]++;
				}
			}
		}

		// 같은 구역끼리 가능한 조합 계산
		for (int i = 1; i <= compId; i++) {
			ans += cntA[i] * cntB[i];
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
