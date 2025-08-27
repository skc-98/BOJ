import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 두개 입력
		String s1 = br.readLine();
		String s2 = br.readLine();

		// 두 문자열 길이의 최소 공배수
		BigInteger s1Len = BigInteger.valueOf(s1.length());
		BigInteger s2Len = BigInteger.valueOf(s2.length());
		BigInteger sgcd = s1Len.gcd(s2Len);
		BigInteger slcm = s1Len.multiply(s2Len);
		slcm = slcm.divide(sgcd);

		// 길이에 맞게 이어 붙히기
		String ns1 = s1;
		String ns2 = s2;
		while (!slcm.equals(BigInteger.valueOf(ns1.length()))) {
			ns1 += s1;
		}
		while (!slcm.equals(BigInteger.valueOf(ns2.length()))) {
			ns2 += s2;
		}

		// 두 문자열 비교
		if (ns1.equals(ns2))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
