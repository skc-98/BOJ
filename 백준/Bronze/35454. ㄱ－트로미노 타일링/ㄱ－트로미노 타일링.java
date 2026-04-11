import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 타일 크기
			int n = Integer.parseInt(br.readLine());

			// 답 출력하기
			if (n % 3 != 0) {
				System.out.println(0);
			} else {
				System.out.println((long) Math.pow(2, n / 3));
			}
		}
	}
}
