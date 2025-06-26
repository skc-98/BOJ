import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 수를 저장할 배열
		int[] d = new int[n];

		// 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 배열 정렬하기
		Arrays.sort(d);

		// 답을 저장할 변수
		long ans = 0;

		// 누적합
		long sum = 0;

		// 값 더하기
		for (int i = 0; i < n; i++) {
			ans += (long) i * d[i] - sum;
			sum += d[i];
		}

		// 답 출력하기
		ans *= 2;
		System.out.println(ans);
	}
}
