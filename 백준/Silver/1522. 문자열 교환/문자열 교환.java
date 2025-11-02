import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// a의 개수 세기
		int acount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				acount++;
			}
		}

		// 문자열 이어붙히기
		s += s;

		// 초기 구간 내 b의 개수 세기
		int bcount = 0, ans = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			// b면 추가
			if (s.charAt(i) == 'b')
				bcount++;

			// 윈도우 크기 초과 시 왼쪽 문자 제거
			if (i >= acount && s.charAt(i - acount) == 'b')
				bcount--;

			// 윈도우 크기가 acount 이상일 때만 비교
			if (i >= acount - 1) {
				if (bcount < ans)
					ans = bcount;
			}
		}

		// 결과 출력
		System.out.print(ans);
	}
}