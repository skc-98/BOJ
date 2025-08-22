import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 13자리 입력
		String s = br.readLine();

		// 합
		int sum = 0;
		int weight = 0;

		// 각 자리 숫자로 합 구하기
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '*') {
				if (i % 2 == 0) {
					sum += (s.charAt(i) - '0');
				} else {
					sum += ((s.charAt(i) - '0') * 3);
				}
			} else if (s.charAt(i) == '*') {
				weight = i;
			}
		}

		// 답
		int ans = 0;

		// 만약 가중치 1이면
		if (weight % 2 == 0) {
			ans = 10 - (sum % 10);
		}

		// 만약 가중치 3이면
		else {
			for (int d = 0; d <= 9; d++) {
				if ((sum + d * 3) % 10 == 0) {
					ans = d;
					break;
				}
			}
		}

		// 답 출력
		System.out.print(ans);
	}
}
