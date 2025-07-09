import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 방 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 아리스 초기 위치 입력
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		// 규칙표 A
		char[][] ruleA = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				ruleA[i][j] = line.charAt(j);
			}
		}

		// 규칙표 B
		char[][] ruleB = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				ruleB[i][j] = line.charAt(j);
			}
		}

		// 현재 방의 상태를 저장할 배열, true로 초기화
		boolean[][] room = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(room[i], true);
		}

		// 현재 이동거리 저장할 변수
		int moveCount = 0;

		// 마지막 먼지 제거 이후 연속 무먼지 이동 횟수
		int noDustCnt = 0;

		// 답을 저장할 변수
		int answer = 0;

		// 먼지 제거했는지 여부 확인할 변수
		boolean clean = false;

		// 불필요한 이동 방지용 방문 배열
		boolean[][][] visited = new boolean[n][m][4];

		// 아리스 위치에서 시작
		while (true) {
			// 먼지 있는 칸이면
			if (room[x][y]) {
				// 먼지 제거, 방문기록 초기화
				room[x][y] = false;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						Arrays.fill(visited[i][j], false);
					}
				}

				// 규칙 A
				dir = (dir + (ruleA[x][y] - '0')) % 4;

				// 한 칸 전진
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				moveCount++;

				// 밖으로 나가면 지금까지 이동 횟수가 정답
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					answer = moveCount;
					break;
				}

				x = nx;
				y = ny;
				noDustCnt = 0; // 연속 무먼지 이동 초기화
			}
			// 2) 먼지 없는 칸
			else {
				// 같은 방향으로 재방문 시 종료
				if (visited[x][y][dir]) {
					answer = moveCount - noDustCnt;
					break;
				}

				// 방문 기록 남기기
				visited[x][y][dir] = true;
				// B 규칙에 따라 방향 전환
				dir = (dir + (ruleB[x][y] - '0')) % 4;

				// 한 칸 전진
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				moveCount++;
				noDustCnt++;

				// 밖으로 나가면 (전체 이동 횟수 − 연속 무먼지 이동)가 정답
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					answer = moveCount - noDustCnt;
					break;
				}

				x = nx;
				y = ny;
			}

		}

		// 답 출력하기
		System.out.print(answer);
	}
}