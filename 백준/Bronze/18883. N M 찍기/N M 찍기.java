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

		// 답 출력하기
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (j == m) {
					sb.append(num++);
				} else {
					sb.append(num++ + " ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
