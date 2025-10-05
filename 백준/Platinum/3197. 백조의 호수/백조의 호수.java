import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 공간 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 공간 배열 생성
		char[][] d = new char[n][m];

		// 두 백조의 위치를 저장할 배열
		int[][] swan = new int[2][2];
		int swanIdx = 0;

		// 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);

				// 백조의 위치 저장
				if (d[i][j] == 'L') {
					swan[swanIdx][0] = i;
					swan[swanIdx][1] = j;
					swanIdx++;
				}
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 방문 배열과 큐들
		boolean[][] visitSwan = new boolean[n][m];
		boolean[][] visitWater = new boolean[n][m];
		Queue<int[]> swanQ = new ArrayDeque<>();
		Queue<int[]> nextSwanQ = new ArrayDeque<>();
		Queue<int[]> waterQ = new ArrayDeque<>();
		Queue<int[]> nextWaterQ = new ArrayDeque<>();

		// 빙판이 아닌 공간 체크
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] != 'X') {
					waterQ.offer(new int[] { i, j });
					visitWater[i][j] = true;
				}
			}
		}

		// 첫 백조의 위치 큐에 넣기
		swanQ.offer(new int[] { swan[0][0], swan[0][1] });
		visitSwan[swan[0][0]][swan[0][1]] = true;

		// 두 BFS를 번갈아가변서 반복
		while (true) {
			// 종료 조건
			boolean meet = false;

			// 백조 이동 BFS
			while (!swanQ.isEmpty() && !meet) {
				int[] cur = swanQ.poll();
				int x = cur[0];
				int y = cur[1];

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m || visitSwan[nx][ny])
						continue;

					visitSwan[nx][ny] = true;

					if (d[nx][ny] == 'L') {
						meet = true;
						break;
					}

					if (d[nx][ny] == '.') {
						swanQ.offer(new int[] { nx, ny });
					} else if (d[nx][ny] == 'X') {
						nextSwanQ.offer(new int[] { nx, ny });
					}
				}
			}

			// 종료 확인
			if (meet) {
				System.out.print(ans);
				break;
			}

			// 얼음 녹이기 BFS
			while (!waterQ.isEmpty()) {
				int[] cur = waterQ.poll();
				int x = cur[0];
				int y = cur[1];

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || visitWater[nx][ny])
						continue;

					if (d[nx][ny] == 'X') {
						d[nx][ny] = '.';
						nextWaterQ.offer(new int[] { nx, ny });
					}
					visitWater[nx][ny] = true;
				}
			}

			// 다음 날 진행하기
			swanQ = nextSwanQ;
			waterQ = nextWaterQ;
			nextSwanQ = new ArrayDeque<>();
			nextWaterQ = new ArrayDeque<>();
			ans++;
		}
	}
}
