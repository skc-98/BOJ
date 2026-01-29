import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 싱기한 숫자 찾기
		for (int i = 1000; i <= 9999; i++) {
			int dec = digitSum(i, 10);
			int duo = digitSum(i, 12);
			int hex = digitSum(i, 16);

			// 싱기한 숫자면 출력
			if (dec == duo && duo == hex) {
				System.out.println(i);
			}
		}
	}

	// 각 진수 자리 합 구하는 메서드
	static int digitSum(int n, int type) {
		int sum = 0;
		while (n > 0) {
			sum += (n % type);
			n /= type;
		}
		return sum;
	}
}
