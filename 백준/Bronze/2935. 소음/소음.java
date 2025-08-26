import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		BigDecimal a = new BigDecimal(br.readLine());
		String oper = br.readLine();
		BigDecimal b = new BigDecimal(br.readLine());

		// 결과 출력
		if (oper.equals("+")) {
			System.out.println(a.add(b));
		} else if (oper.equals("*")) {
			System.out.println(a.multiply(b));
		}
	}
}
