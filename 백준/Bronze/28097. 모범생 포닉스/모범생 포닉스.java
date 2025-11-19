import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 공부 계획의 수
		int n = Integer.parseInt(br.readLine());

		// 각 계획의 공부 시간
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 총 시간
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += d[i];
		}

		// 계획 사이마다 8시간씩
		if (n > 1)
			total += (n - 1) * 8;

		// 일, 시간으로 변환
		int day = total / 24;
		int hour = total % 24;

		System.out.println(day + " " + hour);
	}
}
