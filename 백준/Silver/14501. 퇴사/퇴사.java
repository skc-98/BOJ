import java.util.*;
import java.io.*;

// 아이디어
// n의 최댓값이 15이기 때문에 부분집합을 모두 구해서 유효성 여부를 판단한 뒤
// 가능한 경우라면 그것이 최대 수익인지 판별하여 답을 구할 수 있습니다.
// 시간제한:2초, 메모리제한:512MB
public class Main {
	// 전역변수 선언
	static int n;
	static int[] period;
	static int[] money;
	static int ans = 0;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 상담의 수 n 입력
		n = Integer.parseInt(br.readLine());

		// n개의 기간과 금액 저장할 배열
		period = new int[n];
		money = new int[n];

		// n개의 기간과 금액 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			period[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}

		// 부분집합을 구하기 위해 backTracking 함수 호출
		visit = new boolean[n];
		backTracking(0);

		// 정답 출력하기
		System.out.print(ans);
	}

	// 모든 부분집합을 구하기
	static void backTracking(int cnt) {
		if (cnt == n) {
			// 해당하는 부분집합이 구해지면 유효성 여부 판단하기
			isPossible();
			return;
		}
		visit[cnt] = false;
		backTracking(cnt + 1);
		visit[cnt] = true;
		backTracking(cnt + 1);
	}

	// 구한 부분집합이 가능한 경우인지 판단하고 최대 수익이라면 값을 갱신
	static void isPossible() {
		int date = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				// 퇴사일 이후라면 불가능하니까 종료
				if (i + period[i] > n)
					return;

				// 현재 날짜와 상담 일자를 비교해서 불가능하면 종료
				if (date > i)
					return;

				// 상담 가능일자로 바꾸고 수익 더하기
				date = i + period[i];
				sum += money[i];
			}
		}
		// 구해진 값이 최대 수익인지 확인하고 갱신
		ans = Math.max(ans, sum);
	}
}
