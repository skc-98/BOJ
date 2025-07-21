import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생들의 수, 학생 키 비교 횟수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 키 관계 저장할 배열
		int[][] d = new int[n + 1][n + 1];

		// m개의 비교 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
		}

		// 플로이드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1)
						d[i][j] = 1;
				}
			}
		}

		// 자신의 순서를 정확히 알 수 있는 학생 수 계산
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 1 || d[j][i] == 1) {
					count++;
				}
			}
			if (count == n - 1)
				ans++;
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
