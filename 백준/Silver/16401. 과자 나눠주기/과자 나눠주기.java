import java.util.*;
import java.io.*;

// 아이디어
// 매개 변수를 통한 이분 탐색 문제입니다.
// 가장 긴 과자의 길이를 기준으로 이분 탐색을 진행하면 답을 구할 수 있습니다.
// 시간제한:1초, 메모리제한:256MB
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 조카의 수, 과자의 수 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 배열에 각 과자의 정보 입력받고, 가장 긴 길이의 과자를 저장
		int longSnack = 0;
		int[] snack = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			if (snack[i] > longSnack)
				longSnack = snack[i];
		}

		// 답을 저장할 변수 ans
		int ans = 0;

		// 가장 긴 과자의 길이를 기준으로 이분탐색을 진행
		int start = 1, end = longSnack;
		while (start <= end) {
			// 중간값 구하기
			int mid = (start + end) / 2;

			// 현재 mid 길이로 만들 수 있는 과자의 숫자 구하기
			int sum = 0;
			for (int i = 0; i < m; i++) {
				sum += (snack[i] / mid);
			}

			// 과자의 숫자가 n보다 크거나 같으면 start 증가
			if (sum >= n) {
				ans = mid;
				start = mid + 1;
			}
			// 과자의 숫자가 n보다 작으면 end 감소
			else {
				end = mid - 1;
			}
		}

		// 정답 출력
		System.out.print(ans);
	}
}
