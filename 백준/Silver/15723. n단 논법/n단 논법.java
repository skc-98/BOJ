import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언
	static List<List<Character>> li;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 인접 리스트 생성
		li = new ArrayList<>();
		for (int i = 'a'; i <= 'z'; i++) {
			li.add(new ArrayList<>());
		}

		// 조건 입력
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			char a = s.charAt(0);
			char b = s.charAt(5);
			li.get(a - 'a').add(b);
		}

		// 찾는 관계 입력
		int rel = Integer.parseInt(br.readLine());
		for (int i = 0; i < rel; i++) {
			String s = br.readLine();
			char from = s.charAt(0);
			char to = s.charAt(5);
			boolean ans = dfs(from, to);

			// 출력
			if (ans) {
				System.out.println("T");
			} else {
				System.out.println("F");
			}
		}
	}

	// DFS 관계 추론
	static boolean dfs(char now, char target) {
		// 만약 관계가 맞는 경우
		if (now == target) {
			return true;
		}

		// DFS 탐색
		for (int i = 0; i < li.get(now - 'a').size(); i++) {
			boolean isTrue = dfs(li.get(now - 'a').get(i), target);
			if (isTrue) {
				return true;
			}
		}

		return false;
	}
}
