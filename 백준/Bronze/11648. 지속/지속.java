import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수 입력
		int n = Integer.parseInt(br.readLine());

		// 한자리 수 될때까지 진행
		int ans = 0;
		while (true) {
			if (n < 10) {
				break;
			}

			// 각 자리수 곱하기
			List<Integer> li = new ArrayList<>();
			while (true) {
				li.add(n % 10);
				n /= 10;
				if (n == 0) {
					break;
				}
			}
			int val = 1;
			for (int i = 0; i < li.size(); i++) {
				val *= li.get(i);
			}
			n = val;
			li.clear();
			ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
