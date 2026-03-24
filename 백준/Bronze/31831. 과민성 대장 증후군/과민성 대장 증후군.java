import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 일수와 기준치
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int stress = Integer.parseInt(st.nextToken());

		// 스트레스 양 입력
		int[] d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 스트레스 넘는 날 구하기
		int ans = 0;
		int now = 0;
		for (int i = 0; i < n; i++) {
			now += d[i];
			if (now < 0)
				now = 0;
			if (now >= stress) {
				ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
