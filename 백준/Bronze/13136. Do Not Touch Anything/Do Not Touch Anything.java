import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long r = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		long n = Integer.parseInt(st.nextToken());

		long a, b;
		if (r % n == 0)
			a = r / n;
		else
			a = (r / n) + 1;

		if (c % n == 0)
			b = c / n;
		else
			b = (c / n) + 1;

		// 답 구하기
		System.out.println(a * b);
	}
}
