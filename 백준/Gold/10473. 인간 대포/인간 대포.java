import java.util.*;
import java.io.*;

// 달리는 경로에 대포 무시 가능
// 달리는 속도는 5m/s, 대포 50m 이동. 발사부터 착지까지 2초
// 달리는 속도로 1m당 0.2초, 대포는 2초 + (거리-50)*0.2
// 대포를 여러 번 타거나 안 타는 것도 가능
public class Main {
	// 대포의 수
	static int n;

	// 시작 위치
	static double x, y;

	// 목적지 위치
	static double dx, dy;

	// 답을 저장할 변수
	static double ans;

	// 각 대포의 위치 저장할 리스트
	static List<double[]> canons;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 현재 위치 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());

		// 목적지 좌표 입력
		st = new StringTokenizer(br.readLine());
		dx = Double.parseDouble(st.nextToken());
		dy = Double.parseDouble(st.nextToken());

		// 대포의 수 입력
		n = Integer.parseInt(br.readLine());

		// 각 대포의 위치 리스트로 저장
		canons = new ArrayList<>();

		// 각 대포의 좌표 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double cx = Double.parseDouble(st.nextToken());
			double cy = Double.parseDouble(st.nextToken());
			canons.add(new double[] { cx, cy });
		}

		// 시작점, 대포들, 도착점을 모두 포함한 리스트 만들기
		List<double[]> points = new ArrayList<>();
		points.add(new double[] { x, y });
		points.addAll(canons);
		points.add(new double[] { dx, dy });

		// 전체 노드 수
		int total = n + 2;

		// 최소 시간 배열
		double[] time = new double[total];
		Arrays.fill(time, Double.MAX_VALUE);
		time[0] = 0;

		// 방문 여부
		boolean[] visited = new boolean[total];

		for (int i = 0; i < total; i++) {
			int current = -1;
			double minTime = Double.MAX_VALUE;

			for (int j = 0; j < total; j++) {
				if (!visited[j] && time[j] < minTime) {
					minTime = time[j];
					current = j;
				}
			}

			// 방문 처리
			visited[current] = true;

			for (int j = 0; j < total; j++) {
				if (visited[j])
					continue;

				// 현재 위치, 다음 위치
				double[] p1 = points.get(current);
				double[] p2 = points.get(j);

				// 두 지점 사이 거리 계산
				double dist = getDistance(p1[0], p1[1], p2[0], p2[1]);

				double moveTime;

				if (current == 0) {
					// 시작점에서는 무조건 걸어가야 함
					moveTime = dist * 0.2;
				} else {
					// 대포에서는 걸어서 가거나 대포 쏘기
					moveTime = Math.min(dist * 0.2, 2 + Math.abs(dist - 50) * 0.2);
				}

				// 더 빠른 시간이면 갱신
				if (time[j] > time[current] + moveTime) {
					time[j] = time[current] + moveTime;
				}
			}
		}

		// 답 출력하기
		System.out.println(time[total - 1]);
	}

	// 거리 계산 메서드
	static double getDistance(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx * dx + dy * dy);
	}
}
