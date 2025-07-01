import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 스택 생성
		Stack<Integer> stack = new Stack<>();

		// 숫자 입력
		String s = br.readLine();

		// 지운 숫자 세기 위한 변수
		int count = 0;

		// 각 숫자를 확인
		for (int i = 0; i < s.length(); i++) {
			int now = s.charAt(i) - '0';

			// 앞 수 보다 크면 스택에서 빼고 작으면 넣기
			while (!stack.isEmpty() && count < m && stack.peek() < now) {
				stack.pop();
				count++;
			}
			stack.push(now);
		}

		// 덜 지운 경우 뒤에서 더 제거
		while (count < m) {
			stack.pop();
			count++;
		}

		// 수의 범위가 크니까 문자열로 출력
		StringBuilder sb = new StringBuilder();
		for (int num : stack) {
			sb.append(num);
		}
		System.out.println(sb.toString());
	}
}
