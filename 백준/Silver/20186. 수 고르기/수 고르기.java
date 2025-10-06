import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수의 수, 고를 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 숫자 배열
		int[] d = new int[n];

		// 수 입력하기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 답 변수
		int ans = 0;

		// 정렬
		Arrays.sort(d);

		// 큰 수 3개 고르기
		for (int i = n - 1; i >= n - k; i--) {
			ans += d[i];
		}

		// 이제 뺄거 빼고
		ans -= (k * (k - 1)) / 2;

		// 답 출력하기
		System.out.print(ans);
	}
}
