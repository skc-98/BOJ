import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		BigInteger c = new BigInteger(st.nextToken());

		// 모듈러 연산
		BigInteger ans = a.modPow(b, c);

		// 답 출력
		System.out.print(ans);
	}
}
