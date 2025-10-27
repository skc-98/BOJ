import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 사람 배열
		int[] d = new int[n];

		// 사람 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 정렬
		Arrays.sort(d);

		// 답 변수
		long ans = 0;

		// 맨 뒷 등수부터 줘버리는게 맞음
		int now = n;
		for (int i = n - 1; i >= 0; i--) {
			ans += Math.abs(now - d[i]);
			now--;
		}

		// 답 출력
		System.out.print(ans);
	}
}
