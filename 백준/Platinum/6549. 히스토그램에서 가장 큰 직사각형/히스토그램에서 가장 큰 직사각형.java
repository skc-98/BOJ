import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종료시까지 입력 받기
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			// 죵료 조건
			if (n == 0)
				break;

			// 배열 생성하기
			int[] d = new int[n + 1];

			// 종료가 아닐 시 입력받기
			for (int i = 0; i < n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}
			d[n] = 0;

			// 스택 생성
			Stack<Integer> stack = new Stack<>();
			long ans = 0;

			// 직사각형 찾기
			for (int i = 0; i <= n; i++) {
				while (!stack.isEmpty() && d[stack.peek()] > d[i]) {
					int height = d[stack.pop()];
					int width;
					if (stack.isEmpty()) {
						width = i;
					} else {
						width = i - stack.peek() - 1;
					}
					long area = (long) height * width;
					if (area > ans) {
						ans = area;
					}
				}
				stack.push(i);
			}

			// 답 출력하기
			System.out.println(ans);
		}
	}
}
