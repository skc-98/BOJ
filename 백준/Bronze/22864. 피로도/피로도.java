import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 최대 일수 구하기
		int tired = 0;
		int ans = 0;

		for (int i = 0; i < 24; i++) {
			if (tired + a <= m) {
				tired += a;
				ans += b;
			} else {
				tired -= c;
				if (tired < 0)
					tired = 0;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
