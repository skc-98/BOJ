import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스트릭 수
		int n = Integer.parseInt(br.readLine());

		// 스트릭 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 스트릭 순회하면서 최장 스트릭 찾기
		int ans = 0;
		int leng = 0;
		for (int i = 0; i < n; i++) {
			if (d[i] == 0) {
				leng = 0;
				continue;
			} else {
				leng++;
				ans = Math.max(ans, leng);
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
