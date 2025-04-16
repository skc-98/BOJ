import java.util.*;
import java.io.*;

public class Main {
	// 이동 방향
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자의 크기, 상어가 든 칸의 수, 냄새 유지 시간 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int smellCount = Integer.parseInt(st.nextToken());

		// 격자의 모습을 저장할 배열
		int[][] d = new int[n][n];

		// 각 상어별 현재 방향과 좌표를 저장해 둘 배열: x, y, 방향 순서로 저장
		int[][] shark = new int[m][3];

		// 격자의 정보 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				if (d[i][j] != 0) {
					shark[d[i][j] - 1][0] = i;
					shark[d[i][j] - 1][1] = j;

				}
			}
		}
		// 상어의 방향 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			shark[i][2] = Integer.parseInt(st.nextToken()) - 1;
		}

		// 상어 이동방향 우선순위 입력할 리스트
		List<int[][]> pdir = new ArrayList<>();

		// 상어 당 4줄씩 방향 우선순위 입력, 위, 아래, 왼쪽, 오른쪽 향할 때 순서
		for (int i = 0; i < m; i++) {
			pdir.add(new int[4][4]);
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					pdir.get(i)[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// 답이 될 시간 저장할 변수
		int ans = 0;

		// 상어의 생존 여부 저장할 논리형 배열
		boolean[] die = new boolean[m];

		// 현재 칸의 냄새 정보 저장할 배열
		int[][] smell = new int[n][n];
		// 현재 칸의 냄새 시간 저장할 배열
		int[][] smellTime = new int[n][n];

		// 초기 냄새 저장
		for (int i = 0; i < m; i++) {
			smell[shark[i][0]][shark[i][1]] = i + 1;
			smellTime[shark[i][0]][shark[i][1]] = smellCount;
		}

		// 조건 만족할때까지 시뮬레이션 돌리기
		while (true) {
			// 종료 조건: 1번 상어를 제외한 모든 상어가 죽었으면 종료
			boolean check = true;
			for (int i = 1; i < m; i++) {
				if (!die[i]) {
					check = false;
					break;
				}
			}
			if (check)
				break;

			// 시간 증가
			ans++;

			// 1000 넘어가면 -1로 초기화 후 종료
			if (ans > 1000) {
				ans = -1;
				break;
			}

			// 새로운 상어 위치를 저장할 배열
			int[][] newD = new int[n][n];
			// 각 상어의 새 좌표와 방향을 저장할 배열
			int[][] newShark = new int[m][3];

			// 모든 상어 이동 시키기
			for (int i = 0; i < m; i++) {
				// 만약 이미 죽은 상어라면 건너뛰기
				if (die[i])
					continue;

				int x = shark[i][0];
				int y = shark[i][1];
				int curDir = shark[i][2];
				int nx = -1, ny = -1, nd = -1;
				boolean moved = false;

				// 냄새가 없는 칸 먼저 찾기
				for (int j = 0; j < 4; j++) {
					// 인덱스에 맞게 -1 처리
					int nextDir = pdir.get(i)[curDir][j] - 1;
					int tx = x + dx[nextDir];
					int ty = y + dy[nextDir];
					if (tx < 0 || tx >= n || ty < 0 || ty >= n)
						continue;
					if (smell[tx][ty] == 0) {
						nx = tx;
						ny = ty;
						nd = nextDir;
						moved = true;
						break;
					}
				}
				// 냄새 없는 칸이 없으면 자신의 냄새 칸 선택
				if (!moved) {
					for (int j = 0; j < 4; j++) {
						int nextDir = pdir.get(i)[curDir][j] - 1;
						int tx = x + dx[nextDir];
						int ty = y + dy[nextDir];
						if (tx < 0 || tx >= n || ty < 0 || ty >= n)
							continue;
						// 현재 상어와 같은 냄새 칸
						if (smell[tx][ty] == i + 1) {
							nx = tx;
							ny = ty;
							nd = nextDir;
							break;
						}
					}
				}

				// 같은 칸에 모이면 번호가 작은 상어 승리
				if (newD[nx][ny] == 0) {
					newD[nx][ny] = i + 1;
					newShark[i][0] = nx;
					newShark[i][1] = ny;
					newShark[i][2] = nd;
				} else {
					// 이미 다른 상어가 해당 칸으로 이동한 경우
					if (newD[nx][ny] > i + 1) {
						// 현재 상어가 더 작으니까 기존 상어 죽이기
						die[newD[nx][ny] - 1] = true;
						newD[nx][ny] = i + 1;
						newShark[i][0] = nx;
						newShark[i][1] = ny;
						newShark[i][2] = nd;
					} else {
						// 현재 상어 번호가 더 크니까 죽이기
						die[i] = true;
					}
				}
			}

			// 상어 정보 갱신하기
			for (int i = 0; i < m; i++) {
				if (die[i])
					continue;
				shark[i][0] = newShark[i][0];
				shark[i][1] = newShark[i][1];
				shark[i][2] = newShark[i][2];
			}

			// 모든 칸의 냄새 유지시간 감소
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (smellTime[i][j] > 0) {
						smellTime[i][j]--;
						// 시간이 0이면 해당 칸 냄새정보 초기화
						if (smellTime[i][j] == 0)
							smell[i][j] = 0;
					}
				}
			}

			// 살아있는 상어가 있는 칸에 냄새 새로 남기기
			for (int i = 0; i < m; i++) {
				if (die[i])
					continue;
				int sx = shark[i][0], sy = shark[i][1];
				smell[sx][sy] = i + 1;
				smellTime[sx][sy] = smellCount;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}