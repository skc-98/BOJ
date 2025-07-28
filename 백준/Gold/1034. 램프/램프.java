import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 탁자의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// map 선언
		Map<String, Integer> mp = new HashMap<>();

		// 행 기준으로 map에 저장
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (mp.containsKey(s)) {
				mp.put(s, mp.get(s) + 1);
			} else {
				mp.put(s, 1);
			}
		}

		// 스위치 전환횟수 저장
		int scount = Integer.parseInt(br.readLine());

		// 답을 저장할 변수
		int ans = 0;

		// 패턴에서 0의 개수 세기
		for (String iter : mp.keySet()) {
			int zcount = 0;
			for (int i = 0; i < iter.length(); i++) {
				if (iter.charAt(i) == '0')
					zcount++;
			}
			if (zcount <= scount && (scount - zcount) % 2 == 0) {
				ans = Math.max(ans, mp.get(iter));
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
