import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// EOF
		String s;
		while ((s = br.readLine()) != null) {
			// 캥거루 입력
			StringTokenizer st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 가장 큰 간격에서 1 빼기
			int result = Math.max(b - a, c - b) - 1;

			// 답 출력하기
			System.out.println(result);
		}
	}
}
