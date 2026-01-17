import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 태어난 날짜 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		// 기준 날짜 입력
		st = new StringTokenizer(br.readLine());
		int y2 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());

		// 나이 계산하기
		int man = y2 - y;
		if (m2 < m || (m2 == m && d2 < d)) {
			man--;
		}

		// 답 출력하기
		System.out.println(man);
		System.out.println(y2 - y + 1);
		System.out.println(y2 - y);
	}
}
