import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수 입력
		String n = br.readLine();

		// 각 자리수 합
		int sum = 0;
		boolean isZero = false;

		// 각 수 돌면서
		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			sum += num;
			if (num == 0)
				isZero = true;
		}

		// 조건 검사
		if (!isZero || sum % 3 != 0) {
			System.out.print(-1);
			return;
		}

		// 30의 배수가 가능하면
		char[] digits = n.toCharArray();
		Arrays.sort(digits);
		for (int i = n.length() - 1; i >= 0; i--) {
			System.out.print(digits[i]);
		}
	}
}