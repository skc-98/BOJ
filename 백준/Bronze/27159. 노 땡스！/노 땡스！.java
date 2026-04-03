import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드의 수
		int n = Integer.parseInt(br.readLine());

		// 카드 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int now = Integer.parseInt(st.nextToken());
		ans += now;
		for (int i = 1; i < n; i++) {
			int next = Integer.parseInt(st.nextToken());
			if (next - now != 1) {
				ans += next;
			}
			now = next;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
