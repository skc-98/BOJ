import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 부서의 수, 각 부서 입력
		int n = Integer.parseInt(br.readLine());
		long[] d = new long[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			for (int j = 0; j < people; j++) {
				int num = Integer.parseInt(st.nextToken());
				d[i] += num;
			}
		}

		// 각 부서 면담시간 합으로 정렬
		Arrays.sort(d);

		// 각 부서 합 시간 누적해서 더하기
		long ans = 0;
		long total = 0;
		for (int i = 0; i < n; i++) {
			total += d[i];
			ans += total;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
