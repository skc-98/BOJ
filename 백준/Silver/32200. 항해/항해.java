import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 샌드위치 수, 값의 범위
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// 샌드위치 입력
		int[] d = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 답 변수
		long ansDay = 0;
		long ansLength = 0;

		// 답 구하기
		for (int i = 0; i < n; i++) {
			int now = d[i];

			// 최대 끼니 수는 X 기준
			long meal = now / x;
			ansDay += meal;

			// 버림 최소화
			long maxEat = meal * (long) y;

			if (now > maxEat) {
				ansLength += (now - maxEat);
			}
		}

		// 답 출력하기
		System.out.println(ansDay);
		System.out.println(ansLength);
	}
}
