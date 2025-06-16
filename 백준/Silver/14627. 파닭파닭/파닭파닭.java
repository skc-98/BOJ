import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 파의 개수 파닭의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// start, end 설정
		int start = 1;
		int end = 1;

		// 파의 정보 저장할 배열
		int[] d = new int[n];

		// 파 전체 길이 합
		long total = 0;

		// 답을 저장할 변수
		int ans = 0;

		// 파의 개수 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
			total += d[i];
			end = Math.max(end, d[i]);
		}

		// 매개변수 탐색 시작
		while (start <= end) {
			int mid = (start + end) / 2;

			// 현재 길이로 잘랐을 때 만들 수 있는 파닭 수
			long count = 0;
			for (int i = 0; i < n; i++) {
				count += d[i] / mid;
			}

			if (count >= m) {
				ans = mid;
				start = mid + 1;
			}
			// 부족하면 더 짧게
			else {
				end = mid - 1;
			}
		}

		// 남은 파 계산
		long left = total - (long) ans * m;

		// 답 출력
		System.out.print(left);
	}
}