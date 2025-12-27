import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 레몬의 수
		int n = Integer.parseInt(br.readLine());

		// 스택에 넣으면서 입력
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int lemon = Integer.parseInt(st.nextToken());
			stack.push(lemon);

			// 제거 반복
			while (true) {
				// 마지막 2개 합이 3
				if (stack.size() >= 2) {
					int a = stack.get(stack.size() - 1);
					int b = stack.get(stack.size() - 2);
					if (a + b == 3) {
						stack.pop();
						stack.pop();
						continue;
					}
				}

				// 마지막 3개가 1,1,1
				if (stack.size() >= 3) {
					int a = stack.get(stack.size() - 1);
					int b = stack.get(stack.size() - 2);
					int c = stack.get(stack.size() - 3);
					if (a == 1 && b == 1 && c == 1) {
						stack.pop();
						stack.pop();
						stack.pop();
						continue;
					}
				}

				break;
			}
		}

		// 답 출력하기
		if (stack.isEmpty()) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
	}
}
