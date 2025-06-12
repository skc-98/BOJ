import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		String n = br.readLine();
		String orig = n;

		// 펠린드롬 만들면서 비교
		while (true) {
			// 부분 문자열 추출
			int len = n.length();
			String s;
			if (len % 2 == 0) {
				s = n.substring(0, len / 2);
			} else {
				s = n.substring(0, len / 2 + 1);
			}

			// 펠린드롬 만들기
			StringBuilder sb = new StringBuilder(s);
			int mirrorStart;
			if (len % 2 == 0) {
				mirrorStart = s.length() - 1;
			} else {
				mirrorStart = s.length() - 2;
			}
			for (int i = mirrorStart; i >= 0; i--) {
				sb.append(s.charAt(i));
			}
			String palindrome = sb.toString();

			// n과 비교
			if (new BigInteger(palindrome).compareTo(new BigInteger(orig)) > 0) {
				System.out.println(palindrome);
				break;
			}

			// s를 증가시켜서 다시 반복
			s = new BigInteger(s).add(BigInteger.ONE).toString();

			// 자릿수 바뀌면 업데이트
			if (s.length() > (len + 1) / 2) {
				StringBuilder temp = new StringBuilder("1");
				for (int i = 0; i < len; i++)
					temp.append("0");
				n = temp.toString();
			} else {
				// 증가한 s를 기준으로 새로운 n 만들기
				StringBuilder newN = new StringBuilder(s);
				for (int i = s.length() - (len % 2 == 0 ? 1 : 2); i >= 0; i--) {
					newN.append(s.charAt(i));
				}
				n = newN.toString();
			}
		}
	}
}
