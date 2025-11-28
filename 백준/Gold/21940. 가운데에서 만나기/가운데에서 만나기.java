import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시의 수 도로의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 인접 행렬 생성, 답 변수
		int[][] d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
			d[i][i] = 0;
		}

		// 소요 시간 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			d[from][to] = value;
		}

		// 친구들의 총 인원 입력
		int friendsNumber = Integer.parseInt(br.readLine());
		List<Integer> li = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < friendsNumber; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}

		// 플로이드-워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE)
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}

		// 왕복시간의 최대값이 최소가 되는 도시들 찾기
		int best = Integer.MAX_VALUE;
		List<Integer> answerList = new ArrayList<>();

		for (int city = 1; city <= n; city++) {

			int maxRoundTrip = 0;
			boolean reachable = true;

			for (int i = 0; i < li.size(); i++) {
				int start = li.get(i);
				if (d[start][city] == Integer.MAX_VALUE || d[city][start] == Integer.MAX_VALUE) {
					reachable = false;
					break;
				}
				int roundTrip = d[start][city] + d[city][start];
				maxRoundTrip = Math.max(maxRoundTrip, roundTrip);
			}

			if (!reachable)
				continue;

			if (maxRoundTrip < best) {
				best = maxRoundTrip;
				answerList.clear();
				answerList.add(city);
			} else if (maxRoundTrip == best) {
				answerList.add(city);
			}
		}

		// 답 출력하기
		for (int i = 0; i < answerList.size(); i++) {
			System.out.print(answerList.get(i) + " ");
		}
	}
}
