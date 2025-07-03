import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자의 개수 n
		int n = Integer.parseInt(br.readLine());

		// 수열 저장 배열
		int[] d = new int[n];

		// 등장 횟수, 결과를 저장할 배열
		int[] freq = new int[1000001];
		int[] result = new int[n];

		// n개의 수 입력하면서 등장 횟수 세기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
			freq[d[i]]++; // 등장 횟수 증가
		}

		// 오등큰수 후보 인덱스를 저장할 스택
		Stack<Integer> stack = new Stack<>();

		// 오른쪽에서 왼쪽으로 탐색
		for (int i = n - 1; i >= 0; i--) {
			// 현재 원소보다 등장 횟수가 작거나 같은 원소는 오등큰수 아님
			while (!stack.isEmpty() && freq[d[i]] >= freq[d[stack.peek()]]) {
				stack.pop();
			}

			// 조건 만족하는 스택 top이 있다면 그게 오등큰수
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = d[stack.peek()];
			}

			// 현재 인덱스를 스택에 push
			stack.push(i);
		}

		// 답 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
