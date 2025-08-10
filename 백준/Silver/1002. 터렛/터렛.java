import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			// 두 원의 교점을 구하는 문제
			long d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
			long sum = (r1 + r2) * (r1 + r2);
			long diff = (r1 - r2) * (r1 - r2);

			if (d == 0 && r1 == r2) {
				System.out.println(-1);
			} else if (d > sum) {
				System.out.println(0);
			} else if (d == sum) {
				System.out.println(1);
			} else if (d < diff) {
				System.out.println(0);
			} else if (d == diff) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}
