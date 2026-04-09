import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수
		int n = Integer.parseInt(br.readLine());

		// 사람 입력
		Integer[] d = new Integer[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 사람 정렬
		Arrays.sort(d, Collections.reverseOrder());

		// 팁 구하기
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int tip = d[i] - i;
			if (tip < 0)
				tip = 0;
			ans += tip;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
