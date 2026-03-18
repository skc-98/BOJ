import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료시까지 반복
		while (true) {
			String s = br.readLine();

			// 종료 조건
			if (s.equals("0")) {
				break;
			}

			// 길이가 1일때까지 반복
			while (s.length() > 1) {
				int sum = 0;

				// 각 자리수 합
				for (int i = 0; i < s.length(); i++) {
					sum += s.charAt(i) - '0';
				}

				s = String.valueOf(sum);
			}

			// 답 출력하기
			System.out.println(s);
		}
	}
}
