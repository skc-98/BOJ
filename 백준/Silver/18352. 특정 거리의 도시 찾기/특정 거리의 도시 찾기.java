import java.util.*;
import java.io.*;

public class Main {
	// 도시의 수, 도로의 수, 거리 정보, 출발 도시 번호
	static int city, road, targetDist, start;

	// 인접 리스트 생성
	static List<Integer>[] roadList;

	// 각 정점 최단 거리 저장할 배열
	static int[] minDist;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시의 수, 도로의 수, 거리 정보, 출발 도시 번호 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		city = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());
		targetDist = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		// 인접 리스트 생성, 인덱스 1번부터 사용
		roadList = new ArrayList[city + 1];
		for (int i = 1; i <= city; i++) {
			roadList[i] = new ArrayList<>();
		}

		// 간선의 정보 입력
		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 간선 정보 입력(단방향)
			roadList[from].add(to);
		}

		// 최단거리 배열 최대값으로 초기화
		minDist = new int[city + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);

		// BFS 탐색을 위한 큐 생성, 방문 배열 생성
		Queue<Integer> q = new ArrayDeque<>();

		// 시작 점 큐에 넣기
		q.add(start);
		minDist[start] = 0;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			int now = q.poll();
			int dist = minDist[now];
			for (int i = 0; i < roadList[now].size(); i++) {
				// 아직 방문하지 않은 경우만
				if (minDist[roadList[now].get(i)] == Integer.MAX_VALUE) {
					minDist[roadList[now].get(i)] = dist + 1;
					q.add(roadList[now].get(i));
				}
			}
		}

		// 논리형 변수
		boolean check = false;

		// 거리가 같은 정점만 출력
		for (int i = 1; i <= city; i++) {
			if (minDist[i] == targetDist) {
				System.out.println(i);
				check = true;
			}
		}

		// 없으면 -1
		if (!check)
			System.out.println(-1);
	}
}
