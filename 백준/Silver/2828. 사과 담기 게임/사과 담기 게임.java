import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스크린 크기, 바구니 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 사과 개수
		int apple = Integer.parseInt(br.readLine());

		// 바구니 위치
		int left = 1;
		int right = m;

		int ans = 0;

		for (int i = 0; i < apple; i++) {
			// 사과 위치 입력
			int now = Integer.parseInt(br.readLine());

			if (now < left) {
				int move = left - now;
				ans += move;
				left -= move;
				right -= move;
			} else if (now > right) {
				int move = now - right;
				ans += move;
				left += move;
				right += move;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
