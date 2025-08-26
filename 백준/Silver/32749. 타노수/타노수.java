import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 타노스한 길이
		Long tLen = (long) Math.pow(2, n - m);

		// 답 변수
		String ans = "0"; // ← BigInteger 대신 문자열로 보관 (변수명/주석 유지)

		// 쪼개야할 수
		String s = br.readLine();

		// 보정
		tLen = Math.max(1L, Math.min(tLen, (long) s.length()));
		int step = tLen.intValue();

		// 쪼개진 길이만큼 수 확인해서 답 구하기
		for (int i = 0; i < s.length(); i += step) {
			int end = Math.min(i + step, s.length());
			if (i >= end) continue;

			String ss = s.substring(i, end).trim();
			if (ss.isEmpty()) continue;

			// 숫자 비교를 문자열 길이+사전순으로 처리 (선행 0 제거)
			String a = stripLeadingZeros(ans);
			String b = stripLeadingZeros(ss);

			if (isGreater(b, a)) ans = b;
		}

		// 답 출력하기
		System.out.print(stripLeadingZeros(ans));
	}

	// 선행 0 제거 (모두 0이면 "0" 유지)
	private static String stripLeadingZeros(String x) {
		int i = 0, n = x.length();
		while (i < n - 1 && x.charAt(i) == '0') i++;
		return x.substring(i);
	}

	// b > a ?
	private static boolean isGreater(String b, String a) {
		if (b.length() != a.length()) return b.length() > a.length();
		return b.compareTo(a) > 0; // 길이 같으면 사전순 비교 = 숫자 비교
	}
}
