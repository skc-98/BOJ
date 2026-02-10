import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 그림 입력
		char[][] d = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 데칼코마니 형성
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				if (d[i][j] == '.' && d[i][m - j - 1] != '.') {
					d[i][j] = d[i][m - j - 1];
				} else if (d[i][j] != '.' && d[i][m - j - 1] == '.') {
					d[i][m - j - 1] = d[i][j];
				}
			}
		}

		// 답 출력하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(d[i][j]);
			}
			System.out.println();
		}
	}
}
