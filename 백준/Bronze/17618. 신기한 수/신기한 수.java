import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정수 입력
		int n = Integer.parseInt(br.readLine());

		// 답 변수
		int ans = 0;

		// 1부터 n까지 다 검사
		for (int i = 1; i <= n; i++) {
			int num = i;
			int sum = 0;

			// 자릿수 합 계산
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}

			// 자릿수 합으로 나누어 떨어지면 신기한 수
			if (i % sum == 0) {
				ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
