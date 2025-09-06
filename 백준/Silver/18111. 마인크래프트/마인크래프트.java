import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n, m, b입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 배열
		int[][] d = new int[n][m];

		// 최소, 최대 높이
		int minHeight = 256, maxHeight = 0;

		// n개의 줄에 m개의 땅 높이 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, d[i][j]);
				maxHeight = Math.max(maxHeight, d[i][j]);
			}
		}

		// 정답 변수
		int ans = Integer.MAX_VALUE;
		int ansHeight = -1;

		// 가능한 높이 탐색
		for (int i = minHeight; i <= maxHeight; i++) {
			int remove = 0;
			int build = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (d[j][k] > i) {
						remove += (d[j][k] - i);
					} else if (d[j][k] < i) {
						build += (i - d[j][k]);
					}
				}
			}

			// 인벤토리 확인
			if (remove + b < build)
				continue;

			// 시간 계산
			int time = remove * 2 + build;

			// 최소 시간 갱신
			if (time < ans || (time == ans && i > ansHeight)) {
				ans = time;
				ansHeight = i;
			}
		}

		// 답 출력하기
		System.out.print(ans + " " + ansHeight);
	}
}
