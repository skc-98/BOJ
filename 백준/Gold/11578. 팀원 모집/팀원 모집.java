import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언
	static int n, m;
	static List<List<Integer>> li;
	static boolean[] choose;
	static boolean[] visit;
	static int ans = Integer.MAX_VALUE;
	static boolean possible = false;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문제의 수, 학생들의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 학생 리스트 생성, 방문 배열 초기화
		li = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			li.add(new ArrayList<>());
		}
		visit = new boolean[n];
		choose = new boolean[m];

		// 학생 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int problem = Integer.parseInt(st.nextToken());
			for (int j = 0; j < problem; j++) {
				int a = Integer.parseInt(st.nextToken());
				li.get(i).add(a);
			}
		}

		// 부분집합 호출
		backTracking(0);

		// 답 출력하기
		if (!possible) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	// 부분집합 메서드
	static void backTracking(int now) {
		// 호출 종료 조건
		if (now == m) {
			boolean check = true;
			for (int i = 0; i < n; i++) {
				if (!visit[i])
					check = false;
			}
			if (check) {
				int count = 0;
				for (int i = 0; i < choose.length; i++) {
					if (choose[i])
						count++;
				}
				ans = Math.min(ans, count);
				possible = true;
			}
			return;
		}

		// 부분집합 구현부
		boolean[] backup = visit.clone();
		for (int i = 0; i < li.get(now).size(); i++) {
			visit[li.get(now).get(i) - 1] = true;
		}
		choose[now] = true;
		backTracking(now + 1);
		visit = backup;
		choose[now] = false;
		backTracking(now + 1);

	}
}
