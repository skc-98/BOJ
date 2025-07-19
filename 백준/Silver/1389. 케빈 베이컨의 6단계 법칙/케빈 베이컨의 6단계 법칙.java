import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 유저 수, 친구 관계의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 친구 관계를 배열에 저장
		int[][] d = new int[n + 1][n + 1];

		// 최댓값으로 초기화
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 999999);
			d[i][i] = 0;
		}

		// 친구 관계 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
			d[b][a] = 1;
		}

		// 플로이드 진행
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}

		// 답을 저장할 변수
		int ans = 0;
		int min = Integer.MAX_VALUE;

		// 답 찾기
		for (int i = 1; i <= n; i++) {
			// 해당 인원의 케빈 베이컨 수 구하기
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += d[i][j];
			}

			// 답 갱신
			if (sum < min) {
				min = sum;
				ans = i;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
