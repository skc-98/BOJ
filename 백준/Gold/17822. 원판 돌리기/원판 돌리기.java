import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 원판의 수, 정수의 수, 회전의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		// 접시 상태 배열
		int[][] d = new int[n + 1][m + 1];

		// 접시 상태 입력
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 입력
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int round = Integer.parseInt(st.nextToken());

			// 회전 시키기
			for (int j = num; j <= n; j += num) {
				round %= m;
				for (int k = 0; k < round; k++) {
					// 시계 방향
					if (dir == 0) {
						int temp = d[j][m];
						for (int p = m; p > 1; p--) {
							d[j][p] = d[j][p - 1];
						}
						d[j][1] = temp;
					}
					// 반시계 방향
					else {
						int temp = d[j][1];
						for (int p = 1; p < m; p++) {
							d[j][p] = d[j][p + 1];
						}
						d[j][m] = temp;
					}
				}
			}

			// 인접하는게 존재하는지 확인하기 위한 변수
			boolean near = false;
			boolean[][] erase = new boolean[n + 1][m + 1];

			// 인접하면서 같은 수 모두 체크
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= m; b++) {
					if (d[a][b] == 0)
						continue;
					// 위
					if (a - 1 > 0 && d[a][b] == d[a - 1][b]) {
						erase[a][b] = erase[a - 1][b] = true;
						near = true;
					}
					// 아래
					if (a + 1 <= n && d[a][b] == d[a + 1][b]) {
						erase[a][b] = erase[a + 1][b] = true;
						near = true;
					}
					// 왼쪽
					int left = (b == 1) ? m : b - 1;
					if (d[a][b] == d[a][left]) {
						erase[a][b] = erase[a][left] = true;
						near = true;
					}
					// 오른쪽
					int right = (b == m) ? 1 : b + 1;
					if (d[a][b] == d[a][right]) {
						erase[a][b] = erase[a][right] = true;
						near = true;
					}
				}
			}

			// 지울거 반영
			if (near) {
				for (int a = 1; a <= n; a++) {
					for (int b = 1; b <= m; b++) {
						if (erase[a][b])
							d[a][b] = 0;
					}
				}
			} else {
				int sum = 0, count = 0;
				for (int a = 1; a <= n; a++) {
					for (int b = 1; b <= m; b++) {
						if (d[a][b] != 0) {
							sum += d[a][b];
							count++;
						}
					}
				}
				if (count > 0) {
					double avg = (double) sum / count;
					for (int a = 1; a <= n; a++) {
						for (int b = 1; b <= m; b++) {
							if (d[a][b] == 0)
								continue;
							if (d[a][b] < avg) {
								d[a][b]++;
							} else if (d[a][b] > avg) {
								d[a][b]--;
							}
						}
					}
				}
			}
		}

		// 모든거 순회하면서 답 구하고 출력
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				ans += d[i][j];
			}
		}
		System.out.print(ans);
	}
}
