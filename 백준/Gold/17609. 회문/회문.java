import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 단어 저장할 배열
		String[] d = new String[n];

		// 각 단어 입력
		for (int i = 0; i < n; i++) {
			d[i] = br.readLine();
		}

		// 각 단어 하나씩 확인하기
		for (int i = 0; i < n; i++) {
			String rs = new StringBuilder(d[i]).reverse().toString();

			// 팰린드롬인 경우
			if (rs.equals(d[i])) {
				System.out.println(0);
				continue;
			}

			// 유사 팰린드롬인 경우 판별
			else {
				boolean check = false;
				int start = 0, end = d[i].length() - 1;
				while (start < end) {
					if (d[i].charAt(start) == d[i].charAt(end)) {
						start++;
						end--;
					} else {
						// 한 글자 제거한 두 경우 중 하나라도 회문이면 유사회문
						if (isPalindrome(d[i], start + 1, end) || isPalindrome(d[i], start, end - 1)) {
							System.out.println(1);
						} else {
							System.out.println(2);
						}
						check = true;
						break;
					}
				}

				// 만약 둘 다 아니면 2
				if (!check)
					System.out.println(2);
			}
		}
	}

	// 부분 회문 판별 함수
	static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}
}
