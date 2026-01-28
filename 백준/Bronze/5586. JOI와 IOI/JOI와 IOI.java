import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// joi랑 ioi 세기
		int jcount = 0;
		int icount = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) == 'J' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
				jcount++;
			} else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
				icount++;
			}
		}

		// 답 출력하기
		System.out.println(jcount);
		System.out.println(icount);
	}
}
