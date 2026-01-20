import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 수 입력
		int n = Integer.parseInt(br.readLine());

		// 결정 여부 확인하기
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int mid = s.length() / 2;
			if (s.charAt(mid - 1) == s.charAt(mid)) {
				System.out.println("Do-it");
			} else {
				System.out.println("Do-it-Not");
			}
		}
	}
}
