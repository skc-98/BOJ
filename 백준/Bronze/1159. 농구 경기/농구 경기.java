import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 선수의 수
		int n = Integer.parseInt(br.readLine());

		// 선수 첫글자 셀 맵
		Map<Character, Integer> map = new HashMap<>();

		// 선수 입력
		for (int i = 0; i < n; i++) {
			String player = br.readLine();
			char first = player.charAt(0);
			map.put(first, map.getOrDefault(first, 0) + 1);
		}

		// 5명 이상인 성씨 찾기
		String ans = "";
		for (char c : map.keySet()) {
			if (map.get(c) >= 5)
				ans += c;
		}

		// 답 출력하기
		if (ans.length() <= 0)
			System.out.println("PREDAJA");
		else
			System.out.println(ans);
	}
}
