import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 전체 입력을 하나의 문자열로 읽기
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line).append('\n');
		}
		String text = sb.toString();
		int idx = 0, n = text.length();

		// 현재 줄에 출력된 문자 수
		int lineLength = 0;

		// 직전에 공백이 있었는지 여부
		boolean prevSpace = false;

		while (idx < n) {
			char c = text.charAt(idx);

			// 공백은 하나로 축소
			if (Character.isWhitespace(c)) {
				idx++;
				prevSpace = true;
				continue;
			}

			// <br> 태그
			if (idx + 4 <= n && text.startsWith("<br>", idx)) {
				System.out.println();
				lineLength = 0;
				prevSpace = false;
				idx += 4;
				continue;
			}

			// <hr> 태그
			if (idx + 4 <= n && text.startsWith("<hr>", idx)) {
				if (lineLength > 0) {
					System.out.println();
				}
				for (int j = 0; j < 80; j++) {
					System.out.print('-');
				}
				System.out.println();
				lineLength = 0;
				prevSpace = false;
				idx += 4;
				continue;
			}

			// 일반 단어는 다음 공백이나 태그 전까지 추출
			int start = idx;
			while (idx < n) {
				if (Character.isWhitespace(text.charAt(idx)))
					break;
				if (idx + 4 <= n && text.startsWith("<br>", idx))
					break;
				if (idx + 4 <= n && text.startsWith("<hr>", idx))
					break;
				idx++;
			}
			String word = text.substring(start, idx);
			int wlen = word.length();

			// 줄바꿈 검사
			int need = (prevSpace && lineLength > 0) ? 1 : 0;
			if (lineLength + need + wlen > 80) {
				System.out.println();
				lineLength = 0;
				prevSpace = false;
			}

			// 공백 출력
			if (prevSpace && lineLength > 0) {
				System.out.print(' ');
				lineLength++;
			}

			// 단어 출력
			System.out.print(word);
			lineLength += wlen;
			prevSpace = false;
		}

		// 마지막 줄 개행 보장
		if (lineLength > 0) {
			System.out.println();
		}
	}
}
