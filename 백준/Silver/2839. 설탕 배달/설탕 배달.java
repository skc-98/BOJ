import java.util.*;
import java.io.*;

// 아이디어
// 시간제한: 1초, 메모리제한: 128MB
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 설탕의 양 n 입력
		int n = Integer.parseInt(br.readLine());

		// 답이 될 최소 봉지의 수를 저장할 ans
		int ans = Integer.MAX_VALUE;

		// 5kg 봉지를 최대로 쓰는 경우
		int five = n / 5;
		// 5kg 봉지를 하나 이상 사용하는 모든 경우
		for (int i = 1; i <= five; i++) {
			// 사용된 봉지의 수 count
			int count = 0;

			// 남은 설탕의 무게 k
			int k = n;

			// 5kg 봉지를 i개 만큼 쓰고 남은 무게
			k -= 5 * i;

			// 사용한 5kg 봉지의 수 추가
			count += i;

			// 남은 무게가 3의 배수가 아니면 넘어가고 3kg 봉지로 다 채울 수 있으면 가능한 경우
			if (k % 3 != 0)
				continue;
			else
				count += (k / 3);

			// 현재까지 구한 최소 봉지수와 비교해서 갱신
			ans = Math.min(ans, count);
		}

		// 3kg 봉지를 최대로 사용하는 수
		int three = n / 3;
		for (int i = 1; i <= three; i++) {
			// 사용한 봉지의 수 count
			int count = 0;

			// 남은 설탕의 무게 k
			int k = n;

			// 3kg 봉지를 i개 만큼 쓰고 남은 무게
			k -= 3 * i;

			// 사용한 3kg 봉지의 수 추가
			count += i;

			// 남은 무게가 5의 배수이면 가능한 경우 아니면 넘어가기
			if (k % 5 != 0)
				continue;
			else {
				count += k / 5;
				ans = Math.min(ans, count);
			}
		}

		// 불가능한 경우 값이 갱신되지 않았으니 -1 출력
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		// 답 출력하기
		System.out.print(ans);
	}
}
