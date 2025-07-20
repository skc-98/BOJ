import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 마을 수, 도로 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 도로 저장할 배열
		int[][] d = new int[n + 1][n + 1];

		// 배열 초기화
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 9999999);
		}

		// m개의 도로 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			d[start][end] = value;
		}

		// 플로이드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// 갱신
					if (d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}

		// 답 저장할 변수
		int ans = Integer.MAX_VALUE;

		// 최소 사이클 찾기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (d[i][j] != 9999999 && d[j][i] != 9999999) {
					ans = Math.min(ans, d[i][j] + d[j][i]);
				}
			}
		}

		// 답 출력하기
		if (ans == Integer.MAX_VALUE)
			System.out.print(-1);
		else
			System.out.println(ans);
	}
}
