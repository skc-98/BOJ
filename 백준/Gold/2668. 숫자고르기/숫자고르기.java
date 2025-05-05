import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int[] d;
	static int n;
	static boolean[] visit;
	static boolean[] finished;
	static List<Integer> li = new ArrayList<>();
	static List<Integer> temp = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		n = Integer.parseInt(br.readLine());

		// 배열 할당
		d = new int[n + 1];

		// n개의 값 입력
		for (int i = 1; i <= n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		visit = new boolean[n + 1];
		finished = new boolean[n + 1];

		// DFS 호출
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				temp.clear();
				dfs(i);
			}
		}

		// 답 출력하기
		Collections.sort(li);
		System.out.println(li.size());
		for (int num : li) {
			System.out.println(num);
		}
	}

	// DFS 메서드
	static void dfs(int now) {
		visit[now] = true;
		temp.add(now);
		int next = d[now];

		// 아직 방문 안했으면 DFS
		if (!visit[next]) {
			dfs(next);
		}

		// 이미 방문 했으면
		else if (!finished[next]) {
			int idx = temp.indexOf(next);
			for (int i = idx; i < temp.size(); i++) {
				if (!li.contains(temp.get(i))) {
					li.add(temp.get(i));
				}
			}
		}
		finished[now] = true;
	}
}
