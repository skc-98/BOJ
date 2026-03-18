import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 개의 공격, 휴식 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		// 타이밍 배열 생성
		int[] time = new int[1001];

		// 공격 휴식 채우기
		for (int i = 1; i <= 1000; i++) {
			if ((i - 1) % (a + b) < a) {
				time[i]++;
			}
			if ((i - 1) % (c + d) < c) {
				time[i]++;
			}
		}

		// 우체부, 우유, 신문
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());

		// 답 출력하기
		System.out.println(time[x]);
		System.out.println(time[y]);
		System.out.println(time[z]);
	}
}
