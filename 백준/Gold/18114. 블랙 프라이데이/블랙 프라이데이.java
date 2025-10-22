import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 물건 수, 제시하는 무게
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 물건 배열
		int[] d = new int[n];

		// 물건 입력, 하나로 가능한지
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
			if (d[i] == c) {
				System.out.println(1);
				return;
			}
		}

		// 정렬
		Arrays.sort(d);

		// 물건 두 개로 가능한지 투포인터
		int left = 0, right = n - 1;
		while (left < right) {
			// 가능한 경우
			if (d[left] + d[right] == c) {
				System.out.println(1);
				return;
			}
			// 아니라면 하나 더 추가해서 해보기
			else if (d[left] + d[right] < c) {
				// 나머지 중 하나 추가해보기
				for (int i = 0; i < n; i++) {
					if (i != left && i != right) {
						if (d[left] + d[right] + d[i] == c) {
							System.out.println(1);
							return;
						}
					}
				}
				// 하나 더 추가해도 안되면
				left++;
			} else {
				right--;
			}
		}

		// 여기까지 오면 안되는거니까 0
		System.out.println(0);
	}
}
