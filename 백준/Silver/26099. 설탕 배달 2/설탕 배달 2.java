import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 설탕 무게
		long n = Long.parseLong(br.readLine());

		// 답 구하기
		long ans = -1;

		// 5짜리를 최대로
		long five = n / 5;

		// 정확히 나누어 떨어질때까지 3짜리 증가
		while (five >= 0) {
			long remain = n - (five * 5);

			// 정확히 나눠지면
			if (remain % 3 == 0) {
				ans = five + (remain / 3);
				break;
			}
			five--;
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
