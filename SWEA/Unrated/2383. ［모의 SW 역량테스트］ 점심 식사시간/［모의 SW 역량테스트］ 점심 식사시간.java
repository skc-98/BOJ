import java.util.*;
import java.io.*;

// 사람의 수가 10명 이하
// 각 사람이 계단을 선택하는 모든 경우의 수를 구해서 => 2^10
// 이동 시간과 내려가는 시간 시뮬레이션
// 주의사항: 계단에는 동시에 3명까지만 올라갈 수 있다!
public class Solution {
	// 방의 정보를 저장할 배열
	static int[][] d;

	// 계단 정보 리스트, 사람 정보 리스트
	static List<People> pInfo;
	static List<Stair> stInfo;

	// 답을 저장할 변수
	static int ans;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 방의 한 변의 길이 입력, 방 생성
			int n = Integer.parseInt(br.readLine());
			d = new int[n][n];

			// 답을 저장할 변수
			ans = Integer.MAX_VALUE;

			// 사람의 수, 사람의 좌표를 저장할 리스트
			int countPeople = 0;
			pInfo = new ArrayList<>();

			// 계단 저장할 리스트
			stInfo = new ArrayList<>();

			// 방의 정보 입력
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
					if (d[i][j] == 1) {
						People people = new People(i, j);
						pInfo.add(people);
						countPeople++;
					} else if (d[i][j] > 1) {
						stInfo.add(new Stair(i, j));
					}
				}
			}

			// 조합을 구해서 시뮬레이션 돌리기
			stairChoice();

			// 답 출력하기
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	// 사람이 어떤 계단 선택하는지 구하는 메서드
	static void stairChoice() {
		// 배열에 선택 정보 저장
		int[] select = new int[pInfo.size()];
		dfs(0, select);
	}

	// DFS 메서드
	static void dfs(int depth, int[] select) {
		// 현재 조합으로 시뮬레이션 진행
		if (depth == pInfo.size()) {
			simulate(select);
			return;
		}

		// 계단 0 선택
		select[depth] = 0;
		dfs(depth + 1, select);

		// 계단 1 선택
		select[depth] = 1;
		dfs(depth + 1, select);
	}

	// 선택된 조합에 따라 시뮬레이션 진행
	static void simulate(int[] select) {
		List<Integer>[] arriveTime = new ArrayList[2];
		for (int i = 0; i < 2; i++)
			arriveTime[i] = new ArrayList<>();

		for (int i = 0; i < select.length; i++) {
			People p = pInfo.get(i);
			Stair s = stInfo.get(select[i]);

			// 이동 시간 계산
			int dist = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
			arriveTime[select[i]].add(dist);
		}

		int[] time = new int[2];
		for (int i = 0; i < 2; i++) {
			time[i] = processStair(arriveTime[i], d[stInfo.get(i).x][stInfo.get(i).y]);
		}

		ans = Math.min(ans, Math.max(time[0], time[1]));
	}

	static int processStair(List<Integer> arrivalList, int stairLen) {
		// 도착 시간 순으로 정렬
		Collections.sort(arrivalList);

		// 실제 계단에 올라간 사람들의 종료시간 관리
		PriorityQueue<Integer> stairQueue = new PriorityQueue<>();

		List<Integer> startTimes = new ArrayList<>();

		for (int arrive : arrivalList) {
			int startTime = arrive + 1;

			// stairQueue 안에 이미 있는 사람들 중에 이 사람보다 먼저 끝나는 사람 제거
			while (!stairQueue.isEmpty() && stairQueue.peek() <= startTime) {
				stairQueue.poll();
			}

			// 계단 위 인원이 3명 이상이면, 기다려야 함
			if (stairQueue.size() >= 3) {
				// 기다려야 하므로, 가장 빨리 끝나는 사람 시간까지 기다림
				int earliestOut = stairQueue.poll();
				startTime = earliestOut; // 이때 진입 가능
				// 이 시점에 다시 올라가므로 다시 큐에 추가해야 함
				// 위에서 poll 했으므로 다시 넣지 않고 아래에서 넣을 때 처리됨
			}

			// 내려가는 데 걸리는 시간 추가
			stairQueue.add(startTime + stairLen);
			startTimes.add(startTime + stairLen); // 최종 완료 시간 기록
		}

		return startTimes.isEmpty() ? 0 : Collections.max(startTimes);
	}

}

// 계단 클래스
class Stair {
	int x, y;

	public Stair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 사람 클래스
class People {
	int x, y;

	public People(int x, int y) {
		this.x = x;
		this.y = y;
	}
}