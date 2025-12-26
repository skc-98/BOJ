import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 책의 수
		int n = Integer.parseInt(br.readLine());

		// 책 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 페이지의 수 구하기
		int ans = 1;
		int now = d[0];
		for (int i = 1; i < n; i++) {
			if (d[i] >= now * 2) {
				ans++;
				now = d[i];
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
