import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 평문 입력
		String s = br.readLine();

		// 암호화 키
		String key = br.readLine();

		// 암호문 만들기
		String ans = "";
		int now = 0;
		for (int i = 0; i < s.length(); i++) {
			// 공백일 경우
			if (s.charAt(i) == ' ') {
				ans += " ";
			}

			// 암호문 더하기
			else {
				int move = key.charAt(now) - 'a' + 1;
				char c = (char) (s.charAt(i) - move);
				if (c < 'a') {
					c += 26;
				}
				ans += c;
			}

			// 키 셋 당기기
			now++;
			if (now == key.length()) {
				now = 0;
			}
		}

		// 암호문 출력하기
		System.out.print(ans);
	}
}
