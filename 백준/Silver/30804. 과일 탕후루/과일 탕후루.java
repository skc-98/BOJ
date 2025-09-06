import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력부분
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 탕후루 입력
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 과일 종류와 수를 배열로 관리
		int[] fcount = new int[10];
		int head = 0, ans = 0, kind = 0;

		for (int tail = 0; tail < n; tail++) {
			if (fcount[d[tail]] == 0)
				kind++;
			fcount[d[tail]]++;

			// 두 종류를 초과하면 head를 이동
			while (kind > 2) {
				fcount[d[head]]--;
				if (fcount[d[head]] == 0)
					kind--;
				head++;
			}

			// 현재 구간 길이로 최대값 갱신
			ans = Math.max(ans, tail - head + 1);
		}

		// 최종적으로 남아있는 과일의 수를 출력
		System.out.println(ans);
	}
}
