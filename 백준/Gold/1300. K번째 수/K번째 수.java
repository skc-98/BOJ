import java.util.*;
import java.io.*;

// 진짜 도저히 아이디어가 안떠올라서 출제자가 풀이법 알려줬음
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n, k 입력
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		// 답을 저장할 변수
		int ans = 0;

		// 이진 탐색 초기값 세팅, 목표하는 값은 절대 k를 넘지 않음
		int start = 1, end = k;

		while (start <= end) {
			int mid = (start + end) / 2;

			// mid 이하의 값 세기
			int count = 0;
			for (int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}

			// k개 이상이면 답은 작거나 같음
			if (count >= k) {
				ans = mid;
				end = mid - 1;
			}
			// 적으면 시작점 늘려서 다시
			else {
				start = mid + 1;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
