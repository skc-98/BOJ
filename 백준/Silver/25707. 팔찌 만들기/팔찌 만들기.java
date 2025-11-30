import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 구슬의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 구슬 배열 및 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 배열 정렬
		Arrays.sort(d);

		// 답 구하기
		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			ans += (d[i + 1] - d[i]);
		}
		ans += (d[n - 1] - d[0]);

		// 답 출력하기
		System.out.println(ans);
	}
}
