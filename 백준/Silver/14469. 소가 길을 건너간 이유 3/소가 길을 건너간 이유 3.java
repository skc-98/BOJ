import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 소의 수
		int n = Integer.parseInt(br.readLine());

		// 배열
		int[][] d = new int[n][2];

		// 소 도착, 검문
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d[i][0] = Integer.parseInt(st.nextToken());
			d[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d, (a, b) -> a[0] - b[0]);

		// 답 변수
		int ans = 0;

		// 모든 소 돌면서 답 구하기
		for (int i = 0; i < n; i++) {
			if (d[i][0] > ans) {
				ans = d[i][0];
				ans += d[i][1];
			} else {
				ans += d[i][1];
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
