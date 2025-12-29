import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 수, 공유기의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 집 좌표 입력
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 집 좌표 정렬
		Arrays.sort(d);

		// 답 변수
		int ans = 0;

		// 매개변수 탐색
		int start = 1, end = d[n - 1] - d[0];
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			int idx = d[0];
			for (int i = 1; i < n; i++) {
				if (d[i] - idx >= mid) {
					idx = d[i];
					cnt++;
				}
			}

			if (cnt >= m) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
