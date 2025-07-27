import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 물건의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 물건 쌍의 개수
		int m = Integer.parseInt(br.readLine());

		// 인접 행렬 생성
		int[][] d = new int[n + 1][n + 1];

		// m개의 비교 결과 입력
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
		}

		// 플로이드 진행
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
					}
				}
			}
		}

		// 답 구하기
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (d[i][j] == 0 && d[j][i] == 0)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
