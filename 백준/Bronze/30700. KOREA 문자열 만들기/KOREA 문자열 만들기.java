import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// KOREA 패턴
		char[] korea = { 'K', 'O', 'R', 'E', 'A' };

		// 현재 문자 인덱스, 답 길이
		int idx = 0;
		int answer = 0;

		// 문자열 왼쪽부터 탐색
		for (int i = 0; i < s.length(); i++) {
			// 현재 문자가 패턴이랑 맞으면
			if (s.charAt(i) == korea[idx]) {
				answer++;
				idx++;

				if (idx == 5) {
					idx = 0;
				}
			}
		}

		// 답 출력하기
		System.out.println(answer);
	}
}
