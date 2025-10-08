import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 접시의 수, 초밥 수, 연속해서 먹는 접시 수, 쿠폰 번호 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int o = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		// 벨트 위 초밥 입력
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 각 초밥의 현재 윈도우 내 개수를 저장할 배열
		int[] count = new int[m + 1];
		int kind = 0;

		// 초기 윈도우 설정
		for (int i = 0; i < o; i++) {
			if (count[d[i]] == 0)
				kind++;
			count[d[i]]++;
		}

		int ans = kind;
		if (count[p] == 0)
			ans++;

		// 슬라이딩 윈도우
		for (int i = 1; i < n; i++) {
			int left = d[i - 1];
			int right = d[(i + o - 1) % n];

			// 왼쪽 초밥 제거
			count[left]--;
			if (count[left] == 0)
				kind--;

			// 오른쪽 초밥 추가
			if (count[right] == 0)
				kind++;
			count[right]++;

			int current = kind;
			if (count[p] == 0)
				current++;

			if (current > ans)
				ans = current;
		}

		// 결과 출력
		System.out.println(ans);
	}
}
