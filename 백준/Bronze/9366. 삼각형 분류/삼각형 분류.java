import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 입력
		int n = Integer.parseInt(br.readLine());

		// 삼각형 입력 후 판단
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 정삼각형
			if (a == b && b == c) {
				System.out.printf("Case #%d: equilateral\n", i);
				continue;
			} else {
				// 가장 큰 변의 길이부터 구하기
				int max = Math.max(a, b);
				max = Math.max(max, c);

				// 가장 큰 변 제외한 합
				int elseSum = 0;
				if (max == a) {
					elseSum += b;
					elseSum += c;
				} else if (max == b) {
					elseSum += a;
					elseSum += c;
				} else if (max == c) {
					elseSum += a;
					elseSum += b;
				}

				// 삼각형의 결정 조건 따지기
				if (max >= elseSum) {
					System.out.printf("Case #%d: invalid!\n", i);
					continue;
				}

				// 이등변 삼각형 여부 확인
				if (a == b || b == c || c == a) {
					System.out.printf("Case #%d: isosceles\n", i);
					continue;
				}

				// 다 아니면 부등변 삼각형임
				else {
					System.out.printf("Case #%d: scalene\n", i);
				}
			}
		}
	}
}
