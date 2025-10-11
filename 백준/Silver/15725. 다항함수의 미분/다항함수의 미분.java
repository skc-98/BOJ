import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 다항식 입력
		String s = br.readLine();

		// x 존재 여부, 일차항 값 저장할 문자열
		String ans = "";
		boolean isX = false;

		// 문자열 확인
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'x') {
				isX = true;
				break;
			}
			ans += s.charAt(i);
		}

		// 답 출력하기
		if (isX) {
			if (ans.equals("") || ans.equals("+"))
				ans = "1";
			else if (ans.equals("-"))
				ans = "-1";

			System.out.println(ans);
		} else {
			System.out.println(0);
		}
	}
}
