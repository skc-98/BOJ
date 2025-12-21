import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 첫 단어 입력
		String word = br.readLine();

		// 첫 단어 알파벳 개수 카운팅
		int[] alpha = new int[26];
		for (int i = 0; i < word.length(); i++) {
			alpha[word.charAt(i) - 'A']++;
		}

		// 답 구하기
		int ans = 0;
		for (int i = 1; i < n; i++) {
			String now = br.readLine();

			// 현재 단어 알파벳 세기
			int[] cur = new int[26];
			for (int j = 0; j < now.length(); j++) {
				cur[now.charAt(j) - 'A']++;
			}

			// 차이 계산
			int plus = 0;
			int minus = 0;
			for (int k = 0; k < 26; k++) {
				int diff = alpha[k] - cur[k];
				if (diff > 0) {
					minus += diff;
				} else if (diff < 0) {
					plus += -diff;
				}
			}

			// 길이 차이에 따른 판정
			int lenDiff = word.length() - now.length();

			// 길이 차이가 2 이상이면 불가능
			if (lenDiff >= 2 || lenDiff <= -2) {
				continue;
			}

			// 완전 동일 또는 한 글자 교체
			if (lenDiff == 0) {
				if ((plus == 0 && minus == 0) || (plus == 1 && minus == 1)) {
					ans++;
				}
				continue;
			}

			// 한글자 짧음
			if (lenDiff == 1) {
				if (minus == 1 && plus == 0) {
					ans++;
				}
				continue;
			}

			// 한글자 김
			if (lenDiff == -1) {
				if (plus == 1 && minus == 0) {
					ans++;
				}
				continue;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
