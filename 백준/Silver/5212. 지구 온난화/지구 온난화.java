import java.util.*;
import java.io.*;

public class Main {
	// 4방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최초 지도 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 지도 배열
		char[][] d = new char[n][m];

		// 지도 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 50년 후 결과 저장용 배열
		char[][] ans = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans[i][j] = d[i][j];
			}
		}

		// 50년 후 지도 계산
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] == 'X') {
					int sea = 0;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						// 지도 밖은 바다로 취급
						if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
							sea++;
						} else if (d[nx][ny] == '.') {
							sea++;
						}
					}

					// 인접한 바다가 3칸 이상이면 잠김
					if (sea >= 3) {
						ans[i][j] = '.';
					}
				}
			}
		}

		// 살아남은 섬의 최소 범위 탐색
		int minX = n, maxX = -1, minY = m, maxY = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ans[i][j] == 'X') {
					minX = Math.min(minX, i);
					maxX = Math.max(maxX, i);
					minY = Math.min(minY, j);
					maxY = Math.max(maxY, j);
				}
			}
		}

		// 답 출력하기
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
}
