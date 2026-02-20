import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 신문 크기 및 스캐너 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 원값 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 4중 for로 스캐너 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < a; j++) {
				for (int k = 0; k < m; k++) {
					for (int l = 0; l < b; l++) {
						System.out.print(d[i][k]);
					}
				}
				System.out.println();
			}
		}
	}
}
