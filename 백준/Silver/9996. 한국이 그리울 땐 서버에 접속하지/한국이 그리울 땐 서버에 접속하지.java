import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 수 입력
		int n = Integer.parseInt(br.readLine());

		// 목표 문자열
		String target = br.readLine();

		// n개의 문자열 비교
		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			// 문자열 길이가 짧은 경우
			if (s.length() < target.length() - 1) {
				System.out.println("NE");
				continue;
			}

			boolean front = false, end = false;

			// 앞에서부터 확인
			int idx = 0;
			for (int j = 0; j < s.length(); j++) {
				if (target.charAt(idx) == '*') {
					front = true;
					break;
				}
				if (s.charAt(j) == target.charAt(idx)) {
					idx++;
				} else {
					break;
				}
			}

			// 뒤에서부터 확인
			idx = target.length() - 1;
			for (int j = s.length() - 1; j >= 0; j--) {
				if (target.charAt(idx) == '*') {
					end = true;
					break;
				}
				if (s.charAt(j) == target.charAt(idx)) {
					idx--;
				} else {
					break;
				}
			}

			// 답 출력
			if (front && end) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}
}
