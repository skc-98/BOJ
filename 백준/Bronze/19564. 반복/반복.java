import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// 답 변수
		int ans = 1;

		// 알파벳은 순서대로니까 이전 알파벳보다 작으면 답 증가
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) >= s.charAt(i + 1)) {
				ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
