import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 0의 개수 구하기
		int ans = 0;
		BigDecimal fac = new BigDecimal(1);
		for (int i = 1; i <= n; i++) {
			BigDecimal num = new BigDecimal(i);
			fac = fac.multiply(num);
		}

		// 문자열로 바꿔서 0의 수 세기
		String factorial = fac.toString();
		for (int i = factorial.length() - 1; i >= 0; i--) {
			if (factorial.charAt(i) != '0')
				break;
			ans++;
		}

		// 답 출력
		System.out.print(ans);
	}
}
