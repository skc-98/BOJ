import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어의 수 입력
		int n = Integer.parseInt(br.readLine());

		// set 선언
		Set<String> st = new HashSet<>();

		// 단어 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String re = new StringBuilder(s).reverse().toString();
			if (s.equals(re)) {
				System.out.print(s.length() + " " + s.charAt(s.length() / 2));
			} else if (st.contains(s) || st.contains(re)) {
				System.out.print(s.length() + " " + s.charAt(s.length() / 2));
			}
			st.add(s);
			st.add(re);
		}
	}
}
