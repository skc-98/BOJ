import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첨탑의 수
		int n = Integer.parseInt(br.readLine());

		// 첨탑 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 첨탑 끝까지 확인하면서 미는 횟수 구하기
		int ans = 1;
		for (int i = 1; i < n; i++) {
			if (d[i] >= d[i - 1]) {
				ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
