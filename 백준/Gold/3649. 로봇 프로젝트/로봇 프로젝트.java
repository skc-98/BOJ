import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// EOF
		String tc = "";
		while ((tc = br.readLine()) != null) {
			// 구멍 크기
			int x = Integer.parseInt(tc) * 10_000_000;

			// 조각의 수
			int n = Integer.parseInt(br.readLine());

			// 조각 배열
			int[] d = new int[n];

			// 조각 입력
			for (int i = 0; i < n; i++) {
				d[i] = Integer.parseInt(br.readLine());
			}

			// 정렬
			Arrays.sort(d);

			// 투 포인터로 조합찾기
			int right = 0;
			int left = n - 1;
			boolean find = false;
			while (right < left) {
				// 찾은 경우에
				if (d[right] + d[left] == x) {
					System.out.println("yes " + d[right] + " " + d[left]);
					find = true;
					break;
				}
				// 찾지 못한 경우
				else if (d[right] + d[left] > x) {
					left--;
				} else {
					right++;
				}
			}
			if (!find) {
				System.out.println("danger");
			}
		}
	}
}
