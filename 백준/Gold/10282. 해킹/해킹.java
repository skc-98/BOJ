import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 컴퓨터 개수, 의존성 개수, 해킹당한 컴퓨터 번호 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 의존성 저장할 인접 리스트 생성
			List<List<Node>> list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			// 의존정 입력, 인접 리스트에 저장
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list.get(b).add(new Node(a, s));
			}

			// 각 컴퓨터가 감염되기까지 걸리는 시간 저장할 배열
			int[] hackTime = new int[n + 1];
			Arrays.fill(hackTime, Integer.MAX_VALUE);

			// 해킹 시작되는 컴퓨터는 0초 걸림
			hackTime[c] = 0;

			// 다익스트라 알고리즘을 통해 감염시간이 짧은 노드부터 처리
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(c, 0));

			// 큐가 빌때까지
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				int nowNum = now.idx;
				int nowTime = now.time;

				// 더 짧은 시간이 있으면 무시하기
				if (hackTime[nowNum] < nowTime)
					continue;

				// 현재 컴퓨터에서 감염시킬 수 있는 컴퓨터 확인하면서
				for (int i = 0; i < list.get(nowNum).size(); i++) {
					Node next = list.get(nowNum).get(i);
					int nextNum = next.idx;
					int nextTime = nowTime + next.time;

					// 더 빠른 감염으로 갱신
					if (hackTime[nextNum] > nextTime) {
						hackTime[nextNum] = nextTime;
						pq.add(new Node(nextNum, nextTime));
					}
				}
			}

			// 답 계산하기
			int count = 0;
			int maxTime = 0;
			for (int i = 1; i <= n; i++) {
				if (hackTime[i] != Integer.MAX_VALUE) {
					count++;
					maxTime = Math.max(maxTime, hackTime[i]);
				}
			}

			// 답 출력하기
			System.out.println(count + " " + maxTime);
		}
	}
}

// 노드 클래스
class Node implements Comparable<Node> {
	int idx;
	int time;

	Node(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}

	// 감염 시간 기준으로 정렬
	@Override
	public int compareTo(Node o) {
		return this.time - o.time;
	}
}