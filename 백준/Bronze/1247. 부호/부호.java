import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 셋 입력
		for (int tc = 1; tc <= 3; tc++) {
			// 정수의 수
			int n = Integer.parseInt(br.readLine());

			// 부호여부 판별할 답
			BigDecimal ans = new BigDecimal(0);

			// 정수 입력
			for (int i = 0; i < n; i++) {
				BigDecimal num = new BigDecimal(br.readLine());
				ans = ans.add(num);
			}

			// 부호 여부 출력
			if (ans.equals(BigDecimal.ZERO)) {
				System.out.println(0);
			} else if (ans.signum() == -1) {
				System.out.println('-');
			} else if (ans.signum() == 1) {
				System.out.println('+');
			}
		}
	}
}
