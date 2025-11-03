import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 음의 수, 프렛의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int pret = Integer.parseInt(st.nextToken());

		// 각 줄별 스택
		Stack<Integer>[] s = new Stack[7];
		for (int i = 1; i <= 6; i++) {
			s[i] = new Stack<>();
		}

		// 답 변수
		long ans = 0;

		// 음 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 현재 줄에서 b보다 큰 프렛들은 모두 뗀다
			while (!s[a].isEmpty() && s[a].peek() > b) {
				s[a].pop();
				ans++;
			}

			// 같은 프렛이면 아무 것도 안 함, 더 낮으면 눌러야 함
			if (s[a].isEmpty()) {
				if (b != 0) {
					s[a].push(b);
					ans++;
				}
			} else {
				if (s[a].peek() < b) {
					s[a].push(b);
					ans++;
				}
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
