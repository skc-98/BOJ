import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 대여소 수 입력
		int n = Integer.parseInt(br.readLine());

		// 대여소 자전거 수 입력
		int[] d = new int[n];
		int[] d2 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d2[i] = Integer.parseInt(st.nextToken());
		}

		// 차이의 절댓값 합
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.abs(d[i] - d2[i]);
		}

		// 답 출력하기
		System.out.println(sum / 2);
	}

}
