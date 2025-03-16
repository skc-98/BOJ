import java.util.*;
import java.io.*;

// 아이디어
// 방향 비순환 그래프를 가지는 건설 순서에서 목표 건물까지 도달하는 순서만 고려하면 되는 문제
// 이 문제에서 중요한 점은 짓지 않아도 되는 건물이 존재하고, 동시에 짓는 건물의 경우 오래 걸리는 건물의 시간만 더하면 됨
// 인접 리스트를 활용한 위상 정렬과 dp를 사용하여 해결
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 건물의 수, 건설순서 규칙의 수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 각 건물 건설에 걸리는 시간
			int[] buildTime = new int[n];

			// 각 건물당 걸리는 시간 입력, 건물 인덱스는 0번부터
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				buildTime[i] = Integer.parseInt(st.nextToken());
			}

			// 각 건물의 진입 차수를 저장할 배열
			int[] degree = new int[n];

			// 건설 규칙을 저장할 인접 리스트와 건설에 필요한 시간을 저장할 dp
			List<Integer>[] d = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				d[i] = new ArrayList<>();
			}
			int[] dp = new int[n];

			// m개의 건설 규칙 인접 리스트에 저장
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int now = Integer.parseInt(st.nextToken()) - 1;
				int next = Integer.parseInt(st.nextToken()) - 1;
				d[now].add(next);

				// 진입 차수 증가
				degree[next]++;
			}

			// 백준이가 승리하기 위해 건설해야 할 건물 번호, 인덱스 0번부터니까 1 빼기
			int victoryNumber = Integer.parseInt(br.readLine()) - 1;

			// 위상 정렬을 위한 큐
			Queue<Integer> q = new ArrayDeque<>();

			// 진입 차수가 0인 건물부터 시작
			for (int i = 0; i < n; i++) {
				// 진입 차수가 0인 시작 건물 큐에 넣고 dp도 초기화
				if (degree[i] == 0) {
					q.add(i);
					dp[i] = buildTime[i];
				}
			}

			// 위상 정렬 진행
			while (!q.isEmpty()) {
				// 현재 짓는 건물 큐에서 빼고
				int now = q.poll();

				// 현재 건물 다음에 짓는 건물들에 대해
				for (int i = 0; i < d[now].size(); i++) {
					// 현재 건물과 연결된 다음 인덱스
					int next = d[now].get(i);

					// 건설 시간 갱신
					dp[next] = Math.max(dp[next], dp[now] + buildTime[next]);

					// 진입 차수 감소하고 0이면 큐에 다시 추가
					degree[next]--;
					if (degree[next] == 0) {
						q.add(next);
					}
				}
			}

			// 답 출력하기
			System.out.println(dp[victoryNumber]);
		}
	}
}