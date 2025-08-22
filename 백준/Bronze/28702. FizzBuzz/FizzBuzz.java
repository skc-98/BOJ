import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 3개 입력
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();

		// 숫자인 값
		int number = 0;

		// 숫자인 값 찾기
		if (!s1.equals("Fizz") && !s1.equals("Buzz") && !s1.equals("FizzBuzz")) {
			number = Integer.parseInt(s1) + 3;
		} else if (!s2.equals("Fizz") && !s2.equals("Buzz") && !s2.equals("FizzBuzz")) {
			number = Integer.parseInt(s2) + 2;
		} else if (!s3.equals("Fizz") && !s3.equals("Buzz") && !s3.equals("FizzBuzz")) {
			number = Integer.parseInt(s3) + 1;
		}

		// 찾은 숫자의 3과 5의 배수관계 확인
		if (number % 3 == 0 && number % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (number % 3 == 0) {
			System.out.println("Fizz");
		} else if (number % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(number);
		}
	}
}
