import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// n개의 줄에 3m개의 정수 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				// 픽셀 값 계산 및 해당 셀 값 출력
				long value = 2126L * a + 7152L * b + 722L * c;

				if (value < 510000) {
					System.out.print("#");
				} else if (value < 1020000) {
					System.out.print("o");
				} else if (value < 1530000) {
					System.out.print("+");
				} else if (value < 2040000) {
					System.out.print("-");
				} else {
					System.out.print(".");
				}
			}
			// 줄바꿈
			System.out.println();
		}
	}
}
