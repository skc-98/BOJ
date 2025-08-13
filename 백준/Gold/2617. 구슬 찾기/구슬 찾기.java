import java.util.*;
import java.io.*;

// 각 구슬 하나에 대해 나보다 큰게 n/2보다 많거나 나보다 작은게 n/2보다 많으면 불가능
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 구슬, 올려본 쌍의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int pair = Integer.parseInt(st.nextToken());

		// 인접 행렬 생성
		int[][] d = new int[n + 1][n + 1];
		int[][] d2 = new int[n + 1][n + 1];

		// 인접 쌍 입력
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
			d2[b][a] = 1;
		}

		// 나보다 가벼운 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] > 0 && d[k][j] > 0)
						d[i][j] = 1;
				}
			}
		}

		// 나보다 무거운 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d2[i][k] > 0 && d2[k][j] > 0)
						d2[i][j] = 1;
				}
			}
		}

		// 답 변수
		int ans = 0;

		// 가능 여부 확인하기
		for (int i = 1; i <= n; i++) {
			int heavy = 0, light = 0;
			for (int j = 1; j <= n; j++) {
				if (d[j][i] == 1)
					heavy++;
				if (d2[j][i] == 1)
					light++;
			}
			if (heavy > n / 2 || light > n / 2)
				ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
