import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사건의 개수, 사건 전후 관계의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 인접 행렬 생성
		int[][] d = new int[n + 1][n + 1];

		// m개의 전후 관계를 아는 두 사건 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
			d[b][a] = -1;
		}

		// 사건의 선후 관계 정립하기
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
						d[j][i] = -1;
					} else if (d[i][k] == -1 && d[k][j] == -1) {
						d[i][j] = -1;
						d[j][i] = 1;
					}
				}
			}
		}

		// 사건의 전후 관계를 알고싶은 사건 쌍의 수 입력
		int rel = Integer.parseInt(br.readLine());
		for (int i = 0; i < rel; i++) {
			// 사건의 전후 관계를 알아내야 하는 쌍 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 해당하는 쌍의 결과 구하고 출력하기
			if (d[a][b] == 0 && d[b][a] == 0) {
				System.out.println(0);
			} else if (d[a][b] == d[b][a]) {
				System.out.println(0);
			} else if (d[a][b] > d[b][a]) {
				System.out.println(-1);
			} else if (d[a][b] < d[b][a]) {
				System.out.println(1);
			}
		}
	}
}
