import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열의 크기
		int n = Integer.parseInt(br.readLine());

		// 수열 배열
		int[] d = new int[n];

		// 수열 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 수열 정렬
		Arrays.sort(d);

		// 답 변수
		int ans = 0;

		// 사용 여부를 확인할 배열
		boolean[] used = new boolean[n];

		// 0의 개수
		int zcount = 0;

		// 뒤에서부터 둘 다 1보다 큰 양수면 곱해서 더하기, 0의 개수도 세두기
		for (int i = n - 1; i >= 0; i--) {
			if ((i - 1) >= 0 && d[i] > 1 && d[i - 1] > 1) {
				ans += (d[i] * d[i - 1]);
				used[i] = true;
				used[i - 1] = true;
				i--;
			}
			if (d[i] == 0) {
				zcount++;
				used[i] = true;
			}
		}

		// 다시 앞에서부터 음수는 큰거끼리 곱해버리기
		for (int i = 0; i < n; i++) {
			if ((i + 1) < n && d[i] < 0 && d[i + 1] < 0 && !used[i] && !used[i + 1]) {
				ans += (d[i] * d[i + 1]);
				used[i] = true;
				used[i + 1] = true;
				i--;
			}
		}

		// 이제 사용안한 수 중에서 음수랑 0 없앨 수 있으면 지우기
		for (int i = 0; i < n; i++) {
			if (!used[i] && d[i] < 0 && zcount > 0) {
				used[i] = true;
				zcount--;
			}
		}

		// 마지막으로 사용 안한 수 다 더하기
		for (int i = 0; i < n; i++) {
			if (!used[i])
				ans += d[i];
		}

		// 답 출력
		System.out.println(ans);
	}
}
