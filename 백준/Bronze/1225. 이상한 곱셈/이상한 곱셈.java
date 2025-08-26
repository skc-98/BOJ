import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();

		// 답 저장할 변수
		BigDecimal ans = BigDecimal.ZERO;

		// 모든 조합 더하기
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				int num = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
				BigDecimal bNum = new BigDecimal(num);
				ans = ans.add(bNum);
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
