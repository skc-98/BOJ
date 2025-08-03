import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 선의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 선 상태 저장할 배열
		boolean[] d = new boolean[10001];

		// 선 입력하기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Arrays.fill(d, a, b, true);
		}

		// 영역 수 세기
		int ans = 0;
		for (int i = 1; i <= 10000; i++) {
			if (d[i])
				ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
