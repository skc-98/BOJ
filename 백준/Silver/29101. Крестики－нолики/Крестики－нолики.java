import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종이 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 격자 상태 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 모든 칸 돌면서
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// . 이면 패스
				if (d[i][j] == '.') {
					continue;
				}

				// 4방향 확인
				for (int k = 0; k < 4; k++) {
					int cnt = 1;

					// 같은 문자 5개 연속인지 확인
					for (int l = 1; l < 5; l++) {
						int nx = i + dx[k] * l;
						int ny = j + dy[k] * l;

						// 범위 검사, 일치 검사
						if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] != d[i][j]) {
							break;
						}
						cnt++;
					}

					// 5개 연속이면 끝
					if (cnt == 5) {
						System.out.print("Yes");
						return;
					}
				}
			}
		}

		// 끝까지 없으면
		System.out.print("No");
	}
}
