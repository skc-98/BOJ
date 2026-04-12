import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기랑 당근 위치 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// 홀짝성 저장
		int start = (x + y) % 2;

		// 같은 홀짝성인 칸에만 당근 심기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if ((i + j) % 2 == start) {
					System.out.print('v');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}
}
