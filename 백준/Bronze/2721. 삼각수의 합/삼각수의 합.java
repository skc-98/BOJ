import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int i = 0; i < tcn; i++) {
			int n = Integer.parseInt(br.readLine());

			// 답 구하기
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				int num = (j + 1) * (j + 2) / 2;
				sum += j * num;
			}

			// 답 출력하기
			System.out.println(sum);
		}
	}
}
