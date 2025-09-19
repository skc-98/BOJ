import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 통나무의 수 입력
			int n = Integer.parseInt(br.readLine());

			// 통나무 배열
			int[] d = new int[n];

			// 통나무 덱
			Deque<Integer> dq = new ArrayDeque<>();

			// 통나무 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}

			// 정렬
			Arrays.sort(d);

			// 통나무 덱에 넣기
			for (int i = n - 1; i >= 0; i--) {
				if (i % 2 == 0) {
					dq.addFirst(d[i]);
				} else {
					dq.addLast(d[i]);
				}
			}

			// 답 변수
			int ans = 0;

			// 높이 차이 계산
			int first = dq.peekFirst();
			int now = dq.pollFirst();
			for (int i = 1; i < n; i++) {
				int next = dq.pollFirst();
				ans = Math.max(ans, Math.abs(now - next));
				now = next;
			}
			ans = Math.max(ans, Math.abs(first - now));

			// 답 출력하기
			System.out.println(ans);
		}
	}
}
