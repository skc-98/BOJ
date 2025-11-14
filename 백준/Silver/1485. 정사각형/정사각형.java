import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 4개 점의 좌표 입력
			int[][] d = new int[4][2];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				d[i][0] = Integer.parseInt(st.nextToken());
				d[i][1] = Integer.parseInt(st.nextToken());
			}

			// 4점 사이의 거리(제곱 거리) 총 6개 계산
			ArrayList<Integer> dist = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				for (int j = i + 1; j < 4; j++) {
					int dx = d[i][0] - d[j][0];
					int dy = d[i][1] - d[j][1];
					int len = dx * dx + dy * dy;
					dist.add(len);
				}
			}

			// 거리 정렬
			Collections.sort(dist);

			// 기본적으로 정사각형이라고 가정
			boolean ok = true;

			// 가장 짧은 변의 길이가 0이면 같은 점이 있음 → 정사각형 불가
			if (dist.get(0) == 0) {
				ok = false;
			}

			// 변 4개가 모두 같은지 확인 (dist[0] ~ dist[3])
			if (ok) {
				int side = dist.get(0);
				for (int i = 1; i < 4; i++) {
					if (dist.get(i) != side) {
						ok = false;
						break;
					}
				}
			}

			// 대각선 2개가 같은지 확인 (dist[4], dist[5])
			if (ok) {
				if (dist.get(4).intValue() != dist.get(5).intValue()) {
					ok = false;
				}
			}

			// 변과 대각선이 달라야 함
			if (ok) {
				if (dist.get(0).intValue() == dist.get(4).intValue()) {
					ok = false;
				}
			}

			// 조건에 따라 출력
			if (ok) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}