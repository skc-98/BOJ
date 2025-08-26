import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		String s = br.readLine();

		// 이진수 정수로 변환
		BigDecimal num = BigDecimal.ZERO;
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int bit = s.charAt(i) - '0';
			BigDecimal pow = BigDecimal.valueOf(2).pow(count);
			num = num.add(pow.multiply(BigDecimal.valueOf(bit)));
			count++;
		}

		// 이진수 정수에 17배
		BigDecimal mul = new BigDecimal(17);
		num = num.multiply(mul);

		// 다시 이진수로 변환
		System.out.println(num.toBigInteger().toString(2));
	}
}
