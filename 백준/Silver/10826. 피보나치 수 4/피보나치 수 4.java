import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// BigInteger로 처리
		BigInteger[] d = new BigInteger[10005];
		d[0] = BigInteger.ZERO;
		d[1] = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1].add(d[i - 2]);
		}

		// 답 출력하기
		System.out.print(d[n]);
	}
}
