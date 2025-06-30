import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 용액의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 용액을 저장할 배열
		int[] d = new int[n];

		// 용액 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 답을 저장할 변수
		long ans = Long.MAX_VALUE;
		int[] sd = new int[3];

		// 하나의 용액은 선택하고 나머지 용액을 투 포인터
		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				long sum = (long) d[i] + d[left] + d[right];
				if (Math.abs(sum) < ans) {
					sd[0] = d[i];
					sd[1] = d[left];
					sd[2] = d[right];
					ans = Math.abs(sum);
				}
				if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		// 답 배열 정렬
		Arrays.sort(sd);

		// 답 출력하기
		for (int i = 0; i < 3; i++) {
			System.out.print(sd[i] + " ");
		}
	}
}
