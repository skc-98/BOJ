import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 레몬의 수
		int n = Integer.parseInt(br.readLine());

		// 1과 2수
		long one = 0;
		long two = 0;

		// 레몬 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int lemon = Integer.parseInt(st.nextToken());
			if (lemon == 1) {
				one++;
			} else if (lemon == 2) {
				two++;
			}
		}

		// 답 출력하기
		if (one >= two && (one - two) % 3 == 0) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
	}
}
