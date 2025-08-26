import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 수 저장할 리스트
		List<Long> li = new ArrayList<>();

		// 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			li.add(Long.parseLong(st.nextToken()));
		}

		// 최대 자리수 높은 순서로 정렬
		Collections.sort(li, (a, b) -> {
			String ab = a.toString() + b.toString();
			String ba = b.toString() + a.toString();
			return ba.compareTo(ab);
		});

		// 문자열 하나로 만들기
		String ans = "";
		for (int i = 0; i < li.size(); i++) {
			ans += li.get(i);
		}

		// 답이 0이 아닌 경우만 출력
		if (ans.charAt(0) != '0') {
			System.out.println(ans);
		} else
			System.out.println(0);
	}
}
