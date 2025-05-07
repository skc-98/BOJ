import java.util.*;
import java.io.*;

public class Main {
	// 단어의 수, 글자의 수
	static int n, k;

	// 답을 저장할 변수
	static int ans = 0;

	// 단어를 저장할 배열
	static String[] d;

	static List<Character> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어의 수, 글자의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// antic 5 빼기
		k -= 5;

		// 단어를 저장할 배열
		d = new String[n];

		// n개의 단어를 입력하면서 a n t i c 제거
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String ss = "";
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) != 'a' && s.charAt(j) != 'n' && s.charAt(j) != 't' && s.charAt(j) != 'i'
						&& s.charAt(j) != 'c') {
					ss += s.charAt(j);
				}
			}
			d[i] = ss;
		}

		// a~z 까지 조합으로 k개 선택
		alpha = new boolean[200];
		alpha['a'] = true;
		alpha['n'] = true;
		alpha['t'] = true;
		alpha['i'] = true;
		alpha['c'] = true;
		for (char i = 'a'; i <= 'z'; i++) {
		    if (i != 'a' && i != 'n' && i != 't' && i != 'i' && i != 'c')
		        list.add(i);
		}
		comb(0, 0);

		// 답 출력하기
		System.out.print(ans);
	}

	// 선택 여부 저장할 배열
	static boolean[] alpha;

	// 조합 메서드
	static void comb(int idx, int depth) {
	    if (depth == k) {
	        Set<Character> st = new HashSet<>();
	        for (char i = 'a'; i <= 'z'; i++) {
	            if (alpha[i]) st.add(i);
	        }
	        countAns(st);
	        return;
	    }

	    for (int i = idx; i < list.size(); i++) {
	        char c = list.get(i);
	        if (!alpha[c]) {
	            alpha[c] = true;
	            comb(i + 1, depth + 1);
	            alpha[c] = false;
	        }
	    }
	}

	// 선택한 알파벳 제거하고 단어 수 세는 메서드
	static void countAns(Set<Character> st) {
		int count = 0;

		// ""이 된 단어의 수가 답
		for (int i = 0; i < n; i++) {
			boolean check = true;
			for (int j = 0; j < d[i].length(); j++) {
				if (!st.contains(d[i].charAt(j))) {
					check = false;
					break;
				}
			}
			// 빈 값이면 가르칠 수 있는 단어니까 카운트
			if (check)
				count++;
		}

		// 답 갱신하기
		ans = Integer.max(ans, count);
	}
}
