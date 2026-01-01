import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드의 수
		int n = Integer.parseInt(br.readLine());

		// 카드 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// n이 1이면 합성 자체가 불가능하므로 0
		if (n == 1) {
			System.out.println(0);
			return;
		}

		// 전체 합과 최댓값 구하기
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum += d[i];
			if (d[i] > max) {
				max = d[i];
			}
		}

		// 최대 카드에 나머지 카드를 계속 붙이는 방식
		int ans = sum + (n - 2) * max;

		// 답 출력하기
		System.out.println(ans);
	}
}
