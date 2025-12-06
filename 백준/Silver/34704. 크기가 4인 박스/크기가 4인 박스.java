import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 물건의 개수
		int n = Integer.parseInt(br.readLine());

		// 물건 입력
		List<Integer> li = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}

		// 각 물건 크기별 개수 세기
		int[] cnt = new int[5];
		for (int i = 0; i < li.size(); i++) {
			cnt[li.get(i)]++;
		}

		// 끝까지 박스 수 구하기
		int ans = 0;

		// 크기 4는 박스 하나씩
		ans += cnt[4];

		// 크기 3은 크기 1이랑 하나의 박스
		ans += cnt[3];
		int match = Math.min(cnt[3], cnt[1]);
		cnt[1] -= match;

		// 크기 2는 두 개씩
		ans += cnt[2] / 2;
		cnt[2] %= 2;

		// 크기 2가 하나 남은 경우 크기 1을 2개
		if (cnt[2] == 1) {
			ans += 1;
			cnt[1] -= Math.min(2, cnt[1]);
		}

		// 남은 크기 1은 4개씩
		if (cnt[1] > 0) {
			ans += (cnt[1] + 3) / 4;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
