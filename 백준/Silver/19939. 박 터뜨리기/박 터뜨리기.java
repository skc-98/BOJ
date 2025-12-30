import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 공의 개수, 팀의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 답 변수
		int ans = -1;

		// 등차수열 최소합
		int min = m * (m + 1) / 2;

		if (n < min) {
			ans = -1;
		} else {
			int rest = n - min;
			// 남는 공 똑같이 나눠지면
			if (rest % m == 0) {
				ans = m - 1;
			}
			// 똑같이 못 나누면
			else {
				ans = m;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
