import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 히스토그램 가로 칸 수 입력
		int n = Integer.parseInt(br.readLine());

		// 히스토그램 배열 생성
		int[] d = new int[n + 1];

		// 히스토그램 막대 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}
		d[n] = 0;

		// 스택 생성
		Stack<Integer> stack = new Stack<>();
		long ans = 0;

		// 히스토그램 탐색
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

		// 답 출력
		System.out.print(ans);
	}
}
