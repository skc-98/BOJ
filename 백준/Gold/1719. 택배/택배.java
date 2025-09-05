import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집하장 수, 집하장간 경로 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 배열 생성
		int[][] d = new int[n + 1][n + 1];
		int[][] next = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 100000000);
			d[i][i] = 0;
		}

		// 집하장간 경로 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			d[start][end] = value;
			d[end][start] = value;
			next[start][end] = end;
			next[end][start] = start;
		}

		// 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}

		// 답 출력하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					System.out.print("- ");
					continue;
				}
				System.out.print(next[i][j] + " ");
			}
			System.out.println();
		}
	}
}
