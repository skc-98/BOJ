import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열의 길이 입력
		int n = Integer.parseInt(br.readLine());

		// 배열과 수열 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 뒤에서부터 최소값을 누적하면서 합 계산
		long sum = 0;
		int min = d[n - 1];
		sum += min;

		for (int i = n - 2; i >= 0; i--) {
			if (d[i] < min)
				min = d[i];
			sum += min;
		}

		// 답 출력하기
		System.out.println(sum);
	}
}
