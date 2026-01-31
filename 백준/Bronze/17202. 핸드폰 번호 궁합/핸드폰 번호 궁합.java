import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 두 번호 입력
		String num1 = br.readLine();
		String num2 = br.readLine();

		// 16자리 만들기
		int[] d = new int[16];
		int idx = 0;
		for (int i = 0; i < 8; i++) {
			d[idx] = num1.charAt(i) - '0';
			idx++;
			d[idx] = num2.charAt(i) - '0';
			idx++;
		}

		// 길이가 2가 될 때까지 줄이기
		int len = 16;
		while (len > 2) {
			for (int i = 0; i < len - 1; i++) {
				d[i] = (d[i] + d[i + 1]) % 10;
			}
			len--;
		}

		// 답 출력하기
		System.out.print(d[0]);
		System.out.print(d[1]);
	}
}
