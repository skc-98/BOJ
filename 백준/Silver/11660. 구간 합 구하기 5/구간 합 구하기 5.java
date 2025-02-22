import java.util.*;
import java.io.*;

// 아이디어
// 2차원 누적합 문제입니다. prefixSum을 구해두고
// 구하려는 구간의 큰 값에서 위쪽 왼쪽의 필요없는 구간을 빼고 두 번 뺀  부분을 다시 합쳐주면 됩니다.
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자의 개수 n, 구해야 하는 합의 수 m
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 배열 정보 입력 받으면서 누적합 구해두기
		int[][] d = new int[n + 1][n + 1];
		int[][] psum = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + d[i][j];
			}
		}

		// 구해둔 누적합을 통해 구간의 합 구하기
		int x1, x2, y1, y2;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int ans = psum[x2][y2] - psum[x1 - 1][y2] - psum[x2][y1 - 1] + psum[x1 - 1][y1 - 1];
			System.out.println(ans);
		}
	}
}
