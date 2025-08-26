import java.util.*;
import java.io.*;

public class Main {
	// 찾는 문자열
	static char[] yonsei = { 'Y', 'O', 'N', 'S', 'E', 'I' };
	static char[] korea = { 'K', 'O', 'R', 'E', 'A' };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// 문자 포인터
		int yPointer = 0;
		int kPointer = 0;

		// 문자열 돌면서 문자열 찾기
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == yonsei[yPointer]) {
				yPointer++;
			}
			if (s.charAt(i) == korea[kPointer]) {
				kPointer++;
			}

			// 문자 찾았을 경우
			if (yPointer == 6) {
				System.out.println("YONSEI");
				return;
			} else if (kPointer == 5) {
				System.out.println("KOREA");
				return;
			}
		}
	}
}
