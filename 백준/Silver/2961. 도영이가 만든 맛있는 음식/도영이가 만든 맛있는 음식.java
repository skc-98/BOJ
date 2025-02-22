import java.util.*;
import java.io.*;

// 아이디어
// 재료를 적어도 하나 이상 사용하는 요리를 만들어야하기 때문에
// 부분집합을 통해 모든 요리의 조합을 구하면 답을 찾을 수 있습니다.
// 주의사항: 재료는 한 가지 이상 꼭 들어가야 하기 때문에 공집합을 포함하지 않도록 주의해야 합니다.
// N(1<=N<=10), 신맛과 쓴맛의 값은 최대 1,000,000,000
// 시간제한: 1초, 메모리 제한: 128MB

public class Main {
	// 전역변수 선언
	static int n;
	static List<Integer> sour;
	static List<Integer> bitter;
	static boolean[] choice;
	static int less = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 재료의 수 n
		n = Integer.parseInt(br.readLine());

		// 각 재료의 맛의 정보 입력
		sour = new ArrayList<>();
		bitter = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour.add(Integer.parseInt(st.nextToken()));
			bitter.add(Integer.parseInt(st.nextToken()));
		}

		// 부분집합 호출
		choice = new boolean[n];
		function(0);

		// 답 출력
		System.out.print(less);
	}

	static void function(int cnt) {
		// 부분집합 구하고 값 갱신할지 정하기
		if (cnt == n) {
			// 신맛의 곱과 쓴맛의 합을 저장할 변수
			int bitterSum = 0, sourSum = 1;
			// 공집합 여부를 처리하기 위한 nullSet 변수
			boolean nullSet = false;

			// 신맛의 곱과 쓴맛의 합 구하기
			for (int i = 0; i < n; i++) {
				if (choice[i]) {
					nullSet = true;
					bitterSum += bitter.get(i);
					sourSum *= sour.get(i);
				}
			}

			// 맛의 차이가 가장 적다면 답 갱신
			if (nullSet && Math.abs(bitterSum - sourSum) < less) {
				less = Math.abs(bitterSum - sourSum);
			}
			return;
		}

		choice[cnt] = true;
		function(cnt + 1);
		choice[cnt] = false;
		function(cnt + 1);
	}
}
