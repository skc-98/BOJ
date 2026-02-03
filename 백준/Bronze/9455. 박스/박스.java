import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 그리드의 크기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// 그리드 상태 입력
			int[][] d = new int[m][n];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 그리드 돌면서 박스 이동 거리 구하기
			int ans = 0;
			for (int j = 0; j < n; j++) {
				// 빈칸 수 세기
				int count = 0;
				for (int i = m - 1; i >= 0; i--) {
					if (d[i][j] == 0) {
						count++;
					} else {
						ans += count;
					}
				}
			}

			// 테스트 케이스의 답 출력하기
			System.out.println(ans);
		}
	}
}
