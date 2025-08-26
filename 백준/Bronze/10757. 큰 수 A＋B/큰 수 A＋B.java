import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 큰 수 두개 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigDecimal a = new BigDecimal(st.nextToken());
		BigDecimal b = new BigDecimal(st.nextToken());

		// 합 출력
		System.out.println(a.add(b));
	}
}
