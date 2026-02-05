import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료시까지 반복
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			// 종료 조건
			if (a == 0 && b == 0 && c == 0 && d == 0) {
				break;
			}

			int maxAge = Math.abs(d - a);
			int minAge = Math.abs(c - b);

			// 답 출력하기
			System.out.println(minAge + " " + maxAge);
		}
	}
}
