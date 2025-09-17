import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 조합 구하기
		BigInteger ans = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			BigInteger now = BigInteger.valueOf(i);
			ans = ans.multiply(now);
		}
		for (int i = m; i >= 1; i--) {
			BigInteger now = BigInteger.valueOf(i);
			ans = ans.divide(now);
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
