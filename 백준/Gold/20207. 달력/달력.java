import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 일정의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 일정 표
		int[] d = new int[500];

		// 일정 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int j = start; j <= end; j++) {
				d[j]++;
			}
		}

		// 답 변수
		int ans = 0;

		// 영역 넓이 구하기
		for (int i = 1; i <= 365; i++) {
			if (d[i] != 0) {
				int maxValue = d[i];
				int len = 0;
				while (d[i] != 0) {
					maxValue = Math.max(maxValue, d[i]);
					len++;
					i++;
				}
				// 영역 넓이 추가하기
				ans += (len * maxValue);
			}
		}

		// 답 출력
		System.out.print(ans);
	}
}
