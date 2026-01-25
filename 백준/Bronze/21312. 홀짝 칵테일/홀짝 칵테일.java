import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 가장 맛있는 칵테일 찾기
		int ans = 0;

		int oddMax = -1;
		int allMax = 0;

		int[] taste = new int[7];
		taste[0] = a;
		taste[1] = b;
		taste[2] = c;
		taste[3] = a * b;
		taste[4] = a * c;
		taste[5] = b * c;
		taste[6] = a * b * c;

		for (int i = 0; i < 7; i++) {
			if (taste[i] > allMax) {
				allMax = taste[i];
			}
			if (taste[i] % 2 != 0) {
				if (taste[i] > oddMax) {
					oddMax = taste[i];
				}
			}
		}

		if (oddMax != -1) {
			ans = oddMax;
		} else {
			ans = allMax;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
