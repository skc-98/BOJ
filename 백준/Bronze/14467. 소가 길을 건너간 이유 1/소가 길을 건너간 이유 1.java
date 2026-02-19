import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 관찰 횟수 입력
		int n = Integer.parseInt(br.readLine());

		// 세팅
		int[] d = new int[101];
		boolean[] seen = new boolean[101];
		int[] count = new int[101];

		// 관찰 결과 입력하면서 확인
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken());
			int state = Integer.parseInt(st.nextToken());

			// 처음 관찰된 소 상태
			if (!seen[cow]) {
				seen[cow] = true;
				d[cow] = state;
				continue;
			}

			// 상태가 변한 경우 카운트 증가
			if (state != d[cow]) {
				count[cow]++;
			}
			d[cow] = state;
		}

		// 답 구하기
		int ans = 0;
		for (int i = 0; i < 101; i++) {
			ans += count[i];
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
