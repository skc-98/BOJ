import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 직사각형 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 직사각형 배열
		int[][] d = new int[n][m];

		// 직사각형 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j) - '0';
			}
		}

		// 답 변수
		int ans = 1;

		// 최대 정사각형의 크기
		int maxSize = Math.min(n, m);

		// 정사각형 크기별로
		for (int size = 1; size < maxSize; size++) {
			for (int i = 0; i + size < n; i++) {
				for (int j = 0; j + size < m; j++) {
					if (d[i][j] == d[i][j + size] && d[i][j] == d[i + size][j] && d[i][j] == d[i + size][j + size]) {
						ans = Math.max(ans, (size + 1) * (size + 1));
					}
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
