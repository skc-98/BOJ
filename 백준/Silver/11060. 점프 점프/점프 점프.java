import java.util.*;
import java.io.*;

public class Main {
	// 전역변수
	static int n;
	static int[] d;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 미로의 크기
		n = Integer.parseInt(br.readLine());

		// 미로 할당
		d = new int[n];

		// 각 칸에 저장된 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// DFS
		memo = new int[n];
		Arrays.fill(memo, Integer.MAX_VALUE);
		dfs(0, 0);

		// 답 출력하기
		if (ans == Integer.MAX_VALUE)
			System.out.print(-1);
		else
			System.out.print(ans);
	}

	// 메모이제이션 추가
	static int[] memo;

	// DFS 메서드
	static void dfs(int now, int cnt) {
		if (now > n - 1) {
			return;
		}
		if (memo[now] <= cnt) {
			return;
		} else {
			memo[now] = cnt;
		}
		if (now == n - 1) {
			ans = Math.min(ans, cnt);
			return;
		}

		for (int i = 1; i <= d[now]; i++) {
			dfs(now + i, cnt + 1);
		}
	}
}
