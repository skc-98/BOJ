import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수
		int n = Integer.parseInt(br.readLine());

		// 섭취량 합
		int oneFour = 0;
		int oneTwo = 0;
		int threeFour = 0;

		// 피자 섭취량 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (s.equals("1/2"))
				oneTwo++;
			else if (s.equals("1/4"))
				oneFour++;
			else if (s.equals("3/4"))
				threeFour++;
		}

		// 이제 필요한 피자 판 수 계산
		int ans = 0;

		// 3/4는 무조건 한 판, 대신 1/4과 짝 지을 수 있음
		ans += threeFour;
		if (oneFour >= threeFour) {
			oneFour -= threeFour;
		} else {
			oneFour = 0;
		}

		// 1/2는 두 개가 한 판
		ans += oneTwo / 2;
		if (oneTwo % 2 == 1) {
			ans += 1;
			oneFour = Math.max(0, oneFour - 2);
		}

		ans += oneFour / 4;
		if (oneFour % 4 > 0)
			ans += 1;

		if (ans == 0)
			ans = 1;

		System.out.print(ans);
	}
}
