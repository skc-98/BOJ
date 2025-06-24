import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		// 더 큰 값과 작은값
		long min = Math.min(a, b);
		long max = Math.max(a, b);

		// 등차수열 합 공식
		long count = max - min + 1;
		long ans = count * (min + max) / 2;

		// 답 출력하기
		System.out.println(ans);
	}
}
