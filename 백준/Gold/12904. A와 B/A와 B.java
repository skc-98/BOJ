import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();
		String ss = br.readLine();

		// 답 변수
		int ans = 0;

		// 목표 문자열 여부 확인
		while (true) {
			// 종료 조건
			if (s.equals(ss)) {
				ans = 1;
				break;
			}
			if (ss.length() == 1) {
				ans = 0;
				break;
			}

			// 조건 1,2
			if (ss.charAt(ss.length() - 1) == 'A') {
				ss = ss.substring(0, ss.length() - 1);
			} else if (ss.charAt(ss.length() - 1) == 'B') {
				String temp = "";
				for (int i = ss.length() - 2; i >= 0; i--) {
					temp += ss.charAt(i);
				}
				ss = temp;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
