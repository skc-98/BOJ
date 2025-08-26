import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		BigDecimal n = new BigDecimal(br.readLine());

		// 제곱근 출력
		System.out.print(n.sqrt(MathContext.UNLIMITED));
	}
}
