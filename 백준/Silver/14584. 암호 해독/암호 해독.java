import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 암호문
		String kaisar = br.readLine();

		// 사전의 단어 입력
		int n = Integer.parseInt(br.readLine());
		String[] d = new String[n];
		for (int i = 0; i < n; i++) {
			d[i] = br.readLine();
		}

		// 알파벳 숫자만큼 밀어보기
		for (int shift = 0; shift <= 26; shift++) {
			String ans = "";

			// 원문 복구
			for (int i = 0; i < kaisar.length(); i++) {
				char now = kaisar.charAt(i);
				if (now == ' ') {
					ans += ' ';
				} else {
					char decoded = (char) ((now - 'a' - shift + 26) % 26 + 'a');
					ans += decoded;
				}
			}

			// 사전 단어 검사
			for (int i = 0; i < n; i++) {
				if (ans.contains(d[i])) {
					System.out.print(ans);
					return;
				}
			}
		}
	}
}
