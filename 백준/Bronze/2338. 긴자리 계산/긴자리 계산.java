import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 두 수 입력
		BigDecimal a = new BigDecimal(br.readLine());
		BigDecimal b = new BigDecimal(br.readLine());

		// 출력
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
	}
}
