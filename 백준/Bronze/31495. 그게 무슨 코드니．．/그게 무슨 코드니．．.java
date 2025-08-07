import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// 올바른 문자열 여부
		if (s.length() >= 2 && s.charAt(0) == '"' && s.charAt(s.length() - 1) == '"') {
			String inner = s.substring(1, s.length() - 1);
			if (inner.length() > 0) {
				System.out.println(inner);
			} else {
				System.out.println("CE");
			}
		} else {
			System.out.println("CE");
		}
	}
}
