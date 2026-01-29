import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력받기
		int n = Integer.parseInt(br.readLine());

		// n이 짝수
		if (n % 2 == 0) {
			System.out.print("I LOVE CBNU");
		}

		// 나머지 경우
		else {
			// 첫 줄
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println();

			// 2번째 줄부터
			int mid = n / 2;
			for (int i = 0; i <= mid; i++) {
				// 앞 공백
				for (int j = 0; j < mid - i; j++) {
					System.out.print(" ");
				}

				// 첫 별
				System.out.print("*");

				// 두 번째 별
				if (i > 0) {
					for (int j = 0; j < 2 * i - 1; j++) {
						System.out.print(" ");
					}
					System.out.print("*");
				}

				System.out.println();
			}
		}
	}
}
