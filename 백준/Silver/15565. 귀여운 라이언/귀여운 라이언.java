import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 인형의 수, 라이언의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 배열
		int[] d = new int[n];

		// 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 답 변수
		int ans = Integer.MAX_VALUE;

		// 투 포인터로 연속 수열 찾기
		int begin = 0, end = 0;
		int lion = 0;

		// 첫 번째 원소 체크
		if (d[0] == 1) {
			lion++;
		}

		while (end < n) {
			if (lion < k) {
				end++;
				if (end < n && d[end] == 1) {
					lion++;
				}
			} else {
				ans = Math.min(ans, end - begin + 1);
				if (d[begin] == 1)
					lion--;
				begin++;
			}
		}

		// 답 출력하기
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
