import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 이름 길이
		int n = Integer.parseInt(br.readLine());

		// 이름 값 구하기
		int ans = 0;
		String s = br.readLine();
		for (int i = 0; i < n; i++) {
			ans += (s.charAt(i) - 'A' + 1);
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
