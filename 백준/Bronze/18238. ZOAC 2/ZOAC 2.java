import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// 답 구하기
		int ans = 0;
		char now = 'A';
		for (int i = 0; i < s.length(); i++) {
			char next = s.charAt(i);
			int diff = Math.abs(now - next);
			ans += Math.min(diff, 26 - diff);
			now = next;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
