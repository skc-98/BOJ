import java.util.*;
import java.io.*;

public class Main {
	// 구역의 수 저장해 둘 변수
	static int n;

	// 인구 수를 저장해 둘 배열
	static int[] population;

	// 도시의 연결 상태를 저장할 배열
	static int[][] link;

	// 답을 저장할 변수
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 구역의 개수 입력
		n = Integer.parseInt(br.readLine());

		// 인구 수 입력
		population = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		// 도시의 연결 상태 행렬로 저장
		link = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= num; j++) {
				int a = Integer.parseInt(st.nextToken());
				link[i][a] = 1;
				link[a][i] = 1;
			}
		}

		// 부분집합을 통해 구역을 두 개로 나누기
		isSelect = new boolean[n + 1];
		backTracking(1);

		// 답 출력하기
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.print(ans);
		}
	}

	// 선택 처리를 위한 배열
	static boolean[] isSelect;

	// 각 각 연결된 도시 두 부분
	static List<Integer> link1 = new ArrayList<>();
	static List<Integer> link2 = new ArrayList<>();

	// 부분집합 구하는 메서드
	static void backTracking(int cnt) {
		if (cnt == n + 1) {
			// 두 부분으로 나눈거 리스트에 넣기
			for (int i = 1; i <= n; i++) {
				if (isSelect[i] == true) {
					link1.add(i);
				} else
					link2.add(i);
			}

			// 이제 나눈게 가능한지 확인하고 계산
			isPossible();

			link1.clear();
			link2.clear();
			return;
		}

		isSelect[cnt] = true;
		backTracking(cnt + 1);
		isSelect[cnt] = false;
		backTracking(cnt + 1);
	}

	// 나눈 구역이 성립하는지 확인하는 메서드
	static void isPossible() {
		// 공집합 방지
		if (link1.isEmpty() || link2.isEmpty())
			return;

		// 각 그룹의 연결 검사 후 가능한 경우면 인구수 차이를 계산해서 답을 갱신
		if (checkConnect(link1) && checkConnect(link2)) {
			int sum1 = 0;
			for (int num : link1) {
				sum1 += population[num];
			}
			int sum2 = 0;
			for (int num : link2) {
				sum2 += population[num];
			}
			// 최소값이면 갱신
			ans = Math.min(ans, Math.abs(sum1 - sum2));
		}
	}

	// 각 그룹의 연결을 플로이드-워셜을 통해 검사
	static boolean checkConnect(List<Integer> group) {
		// 그룹 내에 하나라도 구역이 없으면 false 반환
		if (group.isEmpty())
			return false;

		int size = group.size();
		// 그룹 내 정점을 대상으로 하는 dp
		boolean[][] dp = new boolean[size][size];

		// 같은 노드는 true, 두 노드가 연결되어 있으면 true
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					dp[i][j] = true;
				} else {
					int nodeA = group.get(i);
					int nodeB = group.get(j);
					dp[i][j] = (link[nodeA][nodeB] == 1);
				}
			}
		}

		// 플로이드-워셜을 통해 연결해둔 정점에 경로가 존재하는지 확인
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j]);
				}
			}
		}

		// 연결되어 있는지 확인
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!dp[i][j])
					return false;
			}
		}
		return true;
	}
}