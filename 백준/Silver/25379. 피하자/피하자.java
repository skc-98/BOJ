import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열의 길이 입력
		int n = Integer.parseInt(br.readLine());

		// 배열 생성
		int[] d = new int[n];

		// 배열의 원소 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 짝수를 앞으로, 홀수는 뒤로 구하기
		long costEven = 0L, costOdd = 0L;
		long cntEven = 0L, cntOdd = 0L;
		for (int i = 0; i < n; i++) {
			if (d[i] % 2 == 0) {
				costEven += (i - cntEven);
				cntEven++;
			} else {
				costOdd += (i - cntOdd);
				cntOdd++;
			}
		}

		System.out.println(Math.min(costEven, costOdd));
	}
}
