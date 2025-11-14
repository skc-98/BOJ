import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n, m;
	static int[][] d;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 수, 대피소 설치할 집의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 집의 위치 입력
		d = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			d[i][0] = Integer.parseInt(st.nextToken());
			d[i][1] = Integer.parseInt(st.nextToken());
		}

		// 조합 호출
		comb(0, 0, new ArrayList<>());

		// 답 출력하기
		System.out.print(ans);
	}

	// 조합 메서드
	static void comb(int idx, int depth, List<Integer> li) {
		if (depth == m) {
			int now = evaluate(li);
			ans = Math.min(ans, now);
			return;
		}

		if (idx == n)
			return;

		// 재귀
		li.add(idx);
		comb(idx + 1, depth + 1, li);
		li.remove(li.size() - 1);
		comb(idx + 1, depth, li);
	}

	// 거리 계산
	static int evaluate(List<Integer> li) {
		int maxDist = 0;
		for (int i = 0; i < n; i++) {
			int minDist = Integer.MAX_VALUE;

			for (int j = 0; j < li.size(); j++) {
				int dist = Math.abs(d[i][0] - d[li.get(j)][0]) + Math.abs(d[i][1] - d[li.get(j)][1]);
				minDist = Math.min(minDist, dist);
			}

			if (minDist > maxDist)
				maxDist = minDist;
		}
		return maxDist;
	}
}
