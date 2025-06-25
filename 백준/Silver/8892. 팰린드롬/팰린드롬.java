import java.util.*;
import java.io.*;

public class Main {
	// 단어 배열
	static String[] d;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < tcn; tc++) {
			// 단어의 수 입력
			int n = Integer.parseInt(br.readLine());

			// 단어 저장할 배열
			d = new String[n];

			// 단어 입력
			for (int i = 0; i < n; i++) {
				d[i] = br.readLine();
			}

			// 백트래킹으로 모든 조합 구하기
			boolean check = backTracking(n);

			// 단어가 없을때만 0 출력
			if (check == false) {
				System.out.println(0);
			}
		}
	}

	// 모든 조합 구할 메서드
	static boolean backTracking(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// 앞으로 더했을때
				String s1 = d[i] + d[j];
				if (isPal(s1)) {
					System.out.println(s1);
					return true;
				}
				// 뒤로 더했을때
				String s2 = d[j] + d[i];
				if (isPal(s2)) {
					System.out.println(s2);
					return true;
				}
			}
		}
		return false;
	}

	// 팰린드롬 확인 메서드
	static boolean isPal(String s) {
		String ss = new StringBuilder(s).reverse().toString();
		return ss.equals(s);
	}
}
