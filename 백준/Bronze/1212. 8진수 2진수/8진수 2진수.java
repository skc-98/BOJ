import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 8진수 입력
		String octal = br.readLine();

		// 10진수 변환
		BigInteger decimal = new BigInteger(octal, 8);

		// 2진수 변환
		String binary = decimal.toString(2);

		// 답 출력
		System.out.print(binary);
	}
}
