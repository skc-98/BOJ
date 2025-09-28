import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 일차함수의 수
		int n = Integer.parseInt(br.readLine());

		// a값 배열과 b의 합
		long[] aList = new long[n];
		long sumB = 0;

		// 일차함수 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			aList[i] = a;
			sumB += b;
		}

		// a 정렬
		Arrays.sort(aList);

		// 답 구하기
		long ans = sumB;
		for (int i = 0; i < n; i++) {
			ans += aList[i] * (i + 1);
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
