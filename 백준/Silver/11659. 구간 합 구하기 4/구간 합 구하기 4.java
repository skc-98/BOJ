import java.util.*;
import java.io.*;

// 아이디어
// 1차원 누적합 문제입니다. prefixSum을 구해두고 구하려는 구간의 큰 값에서 작은 값을 빼면 됩니다.
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자의 개수 n, 구해야 하는 합의 수 m
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// psum 배열에 누적합을 저장
		st = new StringTokenizer(br.readLine());
		int[] psum = new int[n + 1];
		psum[0] = 0;
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			psum[i] = psum[i - 1] + num;
		}

		// 각 구간의 합을 구해서 출력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(psum[end] - psum[start - 1]);
		}
	}
}
