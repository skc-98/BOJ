import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료시까지 반복
		while (true) {
			int n = Integer.parseInt(br.readLine());

			// 종료 조건
			if (n == 0)
				break;

			// 삼각형 출력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
