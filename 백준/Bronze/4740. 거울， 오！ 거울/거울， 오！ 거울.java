import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료시까지 반복
		while (true) {
			String s = br.readLine();
			if (s.equals("***")) {
				break;
			}

			// 거울 출력
			for (int i = s.length() - 1; i >= 0; i--) {
				System.out.print(s.charAt(i));
			}
			System.out.println();
		}
	}
}
