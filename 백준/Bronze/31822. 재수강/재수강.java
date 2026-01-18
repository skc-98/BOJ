import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 재수강 할 과목
		String s = br.readLine();

		// 과목 수
		int n = Integer.parseInt(br.readLine());

		// 과목 입력하면서 답 구하기
		int ans = 0;
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			if (s.substring(0, 5).equals(now.substring(0, 5)))
				ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
