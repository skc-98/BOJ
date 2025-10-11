import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 답 변수, 중복 판별을 위한 셋
		Set<String> set = new HashSet<>();

		// 단어 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String min = s;

			// 회문 중 사전순으로 빠른거 찾기
			for (int j = 1; j < s.length(); j++) {
				String ss = s.substring(j) + s.substring(0, j);
				if (ss.compareTo(min) < 0) {
					min = ss;
				}
			}

			// 구한 빠른거 셋에 넣기
			set.add(min);
		}

		// 셋 크기가 답임
		System.out.print(set.size());
	}
}
