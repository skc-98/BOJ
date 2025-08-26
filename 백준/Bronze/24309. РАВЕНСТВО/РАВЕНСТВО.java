import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main{
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// a,b,c 입력
		BigDecimal a = new BigDecimal(br.readLine());
		BigDecimal b = new BigDecimal(br.readLine());
		BigDecimal c = new BigDecimal(br.readLine());

		// x 구하기
		BigDecimal ans = new BigDecimal(1);
		ans = ans.multiply(b);
		ans = ans.subtract(c);
		ans = ans.divide(a, 0, RoundingMode.HALF_DOWN);

		// 답 출력
		System.out.println(ans);
	}
}
