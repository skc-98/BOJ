import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 체스판 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 행의 높이, 너비 입력
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 체스판 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < a; j++) {
				for (int k = 0; k < m; k++) {
					char c;
					if ((i + k) % 2 == 0) {
						c = 'X';
					} else {
						c = '.';
					}

					for (int t = 0; t < b; t++) {
						System.out.print(c);
					}
				}
				System.out.println();
			}
		}

	}
}
