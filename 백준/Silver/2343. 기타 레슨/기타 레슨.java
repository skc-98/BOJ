import java.util.*;
import java.io.*;

// 아이디어
// 각 블루레이의 크기를 최대로 설정하고 그 크기를 기준으로 이분탐색하면 최적해를 구할 수 있습니다.
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 강의의 수, 블루레이 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 각 강의를 저장할 배열
		int[] d = new int[n];

		// 매개 변수 탐색을 위한 초기값 세팅
		int start = 0, end = 0;

		// 각 강의의 길이 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
			end += d[i];
		}

		// 답을 저장할 변수
		int ans = 0;

		// 매개 변수 탐색 시작
		while (start <= end) {
			int mid = (start + end) / 2;

			// 현재 구한 중앙 값을 기준으로 강의를 나눠보기
			int sum = 0;
			int count = 1;
			for (int i = 0; i < n; i++) {
				// 강의 자체가 블루레이보다 크면 불가능한 경우라 다음 값 호출해야함
				if (d[i] > mid) {
					count = m + 1;
					break;
				}

				// 다음 강의 합친게 블루레이보다 크면 블루레이 하나 더 사용하기
				if (sum + d[i] > mid) {
					count++;
					sum = 0;
				}
				sum += d[i];
			}

			// 현재 블루레이 수로 가능하니까 최적해일 가능성이 있음, 답으로 저장하고 다음 값 호출
			if (count <= m) {
				ans = mid;
				end = mid - 1;
			}
			// 이 경우는 값이 너무 작은거니까 start 키우기
			else {
				start = mid + 1;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
