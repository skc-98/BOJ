import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 포도주의 수, 산들이 주량 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 포도주 맛 배열
		int[] d = new int[n];

		// 포도주 맛 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 주량이 1일때
		if (m == 1 || m == 2) {
			System.out.println(d[n - 1]);
			return;
		}

		int p = (m + 1) / 2;	
		int q = p - 1;

		long ans = 0;
		for (int i = 0; i < p; i++)
			ans += d[n - 1 - i];
		for (int i = 0; i < q; i++)
			ans -= d[i];

		System.out.println(ans);
	}
}
