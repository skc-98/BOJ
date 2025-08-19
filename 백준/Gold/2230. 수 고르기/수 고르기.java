import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 수를 저장할 배열
		int[] d = new int[n];

		// 수 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 정렬
		Arrays.sort(d);

		// 답 저장할 변수
		int ans = Integer.MAX_VALUE;

		// 투 포인터로 최솟값 찾기
		int start = 0;
		int end = 0;
		while (start < n && end < n) {
			int diff = d[end] - d[start];
			if (diff < m) {
				end++;
			} else {
				start++;
				ans = Math.min(ans, diff);
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
