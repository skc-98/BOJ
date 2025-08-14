import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수, 관계 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int rel = Integer.parseInt(st.nextToken());

		// 인접행렬 생성
		int[][] d = new int[n + 1][n + 1];

		// 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					d[i][j] = 0;
				else
					d[i][j] = 99999;
			}
		}

		// 친구 관계 입력
		for (int i = 0; i < rel; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
			d[b][a] = 1;
		}

		// 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}

		// 네트워크 여부 검사
		boolean ans = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (d[i][j] > 6) {
					ans = false;
				}
			}
		}

		// 답 출력
		if (ans)
			System.out.print("Small World!");
		else
			System.out.println("Big World!");
	}
}
