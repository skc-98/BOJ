import java.util.*;
import java.io.*;

public class Main {
	// 4방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 전역변수 선언
	static int n, m, fuel;
	static int[][] d;
	static List<int[]> client;
	static Map<String, Integer> passengerMap;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도 크기, 승객 수, 초기 연료 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		// 지도 할당
		d = new int[n][n];

		// 지도의 상태 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 운전 시작점 입력
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken()) - 1;
		int startY = Integer.parseInt(st.nextToken()) - 1;

		// 각 승객의 출발지와 목적지를 저장해 둘 리스트
		client = new ArrayList<>();

		// 각 승객의 출발지와 승객 번호
		passengerMap = new HashMap<>();

		// 각 승객의 출발지, 목적지 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			client.add(new int[] { sx, sy, ex, ey });
			passengerMap.put(sx + " " + sy, i);
		}

		// 승객 태우는 시뮬레이션 시작
		for (int i = 0; i < m; i++) {
			// 가장 가까운 승객 찾기
			int[] nearInfo = findNearPassenger(startX, startY);
			int nearP = nearInfo[0];
			int distToP = nearInfo[1];

			// 승객 없거나 연료 부족 시 종료
			if (nearP == -1 || fuel < distToP) {
				System.out.println(-1);
				return;
			}

			// 승객 위치로 이동
			fuel -= distToP;
			int[] c = client.get(nearP);
			startX = c[0];
			startY = c[1];

			// 목적지까지 이동
			int distToDest = goToDestination(startX, startY, c[2], c[3]);
			if (distToDest == -1 || fuel < distToDest) {
				System.out.println(-1);
				return;
			}

			// 연료 갱신
			fuel -= distToDest;
			fuel += distToDest * 2;

			// 택시 위치 변경
			startX = c[2];
			startY = c[3];

			// 승객 제거
			passengerMap.remove(c[0] + " " + c[1]);
		}

		// 답 출력하기
		System.out.print(fuel);
	}

	// 가까운 승객을 찾는 메서드
	static int[] findNearPassenger(int x, int y) {
		// BFS 시작
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];
		q.add(new int[] { x, y, 0 });
		visit[x][y] = true;

		// 가장 가까운 승객 후보
		List<int[]> candidate = new ArrayList<>();

		int minDistance = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int nx = q.peek()[0];
			int ny = q.peek()[1];
			int dist = q.peek()[2];
			q.poll();

			// 현재 거리가 더 크면 가지치기
			if (dist > minDistance)
				break;

			// 승객이 있는 칸이면
			String key = nx + " " + ny;
			if (passengerMap.containsKey(key)) {
				// 후보로 추가
				candidate.add(new int[] { nx, ny, dist });
				minDistance = dist;
			}

			// 4방 탐색
			for (int k = 0; k < 4; k++) {
				int cx = nx + dx[k];
				int cy = ny + dy[k];

				// 범위 초과, 방문 검사
				if (cx < 0 || cx >= n || cy < 0 || cy >= n || visit[cx][cy] || d[cx][cy] == 1)
					continue;

				// 방문 처리 후 큐에 추가
				visit[cx][cy] = true;
				q.add(new int[] { cx, cy, dist + 1 });
			}
		}

		// 후보 없으면 -1
		if (candidate.isEmpty())
			return new int[] { -1, -1 };

		// 후보 정렬
		candidate.sort((a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
		});

		// 가장 가까운 후보 반환
		return new int[] { passengerMap.get(candidate.get(0)[0] + " " + candidate.get(0)[1]), candidate.get(0)[2] };
	}

	// 목적지까지 이동하는 BFS
	static int goToDestination(int sx, int sy, int ex, int ey) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];
		q.add(new int[] { sx, sy, 0 });
		visit[sx][sy] = true;

		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			int dist = q.peek()[2];
			q.poll();

			// 목적지 도착하면 거리 반환
			if (cx == ex && cy == ey)
				return dist;

			// 4방 탐색
			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				// 범위, 방문검사
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] == 1)
					continue;

				visit[nx][ny] = true;
				q.add(new int[] { nx, ny, dist + 1 });
			}
		}

		// 목적지 도달 불가
		return -1;
	}
}