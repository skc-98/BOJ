import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long n = Long.parseLong(st.nextToken());
		Long m = Long.parseLong(st.nextToken());

		// 2와 5의 개수를 각각 구함
		long count2 = count(n, 2) - count(m, 2) - count(n - m, 2);
		long count5 = count(n, 5) - count(m, 5) - count(n - m, 5);

		// 답 출력하기
		System.out.println(Math.min(count2, count5));
	}

	// 소인수 개수 세는 함수
	private static long count(long n, int k) {
		long count = 0;
		while (n >= k) {
			count += n / k;
			n /= k;
		}
		return count;
	}
}
