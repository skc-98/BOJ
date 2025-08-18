import java.util.*;
import java.io.*;

public class Main {
	// 4방 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵 크기, 바이러스 종류의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int virus = Integer.parseInt(st.nextToken());

		// 맵 할당
		int[][] d = new int[n][n];

		// 맵 초기상태 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시간, 목표 좌표 입력
		st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());

		// 입력 -1로 박기
		int tx = Integer.parseInt(st.nextToken()) - 1;
		int ty = Integer.parseInt(st.nextToken()) - 1;

		// 시간만큼 BFS 시뮬레이션 진행
		for (int takenTime = 0; takenTime < time; takenTime++) {
			// 바이러스 번호 순서대로 진행
			for (int v = 1; v <= virus; v++) {
				// 방문배열 생성
				boolean[][] visit = new boolean[n][n];

				// 배열 순회하면서 해당 번호 바이러스 만나면 확장
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (d[i][j] == v && !visit[i][j]) {
							for (int k = 0; k < 4; k++) {
								int nx = i + dx[k];
								int ny = j + dy[k];

								if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] != 0)
									continue;
								visit[nx][ny] = true;
								d[nx][ny] = v;
							}
						}
					}
				}
			}
			if (d[tx][ty] != 0)
				break;
		}

		// 답 출력부분
		System.out.print(d[tx][ty]);
	}
}
