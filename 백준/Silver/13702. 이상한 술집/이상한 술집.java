import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 주전자의 수, 친구들의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 주전자의 용량을 저장할 배열
		long[] d = new long[n];

		// start, end 설정
		long start = 1;
		long end = 1;

		// 주전자의 용량 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, d[i]);
		}

		// 매개 변수 탐색
		long ans = 0;
		while (start <= end) {
			long mid = (start + end) / 2;

			long count = 0;
			for (int i = 0; i < n; i++) {
				count += d[i] / mid;
			}

			if (count >= m) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
