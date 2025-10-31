import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n;
	static boolean[] visit;
	static List<List<Integer>> ans;

	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		n = Integer.parseInt(br.readLine());

		// 순열 메서드
		ans = new ArrayList<>();
		visit = new boolean[n + 1];
		backTracking(0, new ArrayList<>());

		// 답 출력하기
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	// 순열 메서드
	static void backTracking(int depth, List<Integer> li) {
		// n개가 모였으면
		if (depth == n) {
			ans.add(new ArrayList<>(li));
			return;
		}

		// 수 선택하기
		for (int i = 1; i <= n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			li.add(i);
			backTracking(depth + 1, li);
			li.remove(li.size() - 1);
			visit[i] = false;
		}
	}
}
