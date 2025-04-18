import java.util.*;
import java.io.*;

// 게임 시작시  뱀은 0,0에 위치, 길이는 1이며 방향은 오른쪽 시작
public class Main {
	// 방향 정의(오,아,왼,위)
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// n*n 크기의 보드 생성
		int[][] d = new int[n][n];

		// 사과의 수 입력
		int apple = Integer.parseInt(br.readLine());
		// 사과 정보 입력
		for (int i = 0; i < apple; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			d[x][y] = -1; // 사과를 -1로 표현
		}

		// 이동방향은 0,1,2,3 순서로 오,아,왼,위
		// 초기 뱀의 이동 방향 오른쪽
		int direction = 0;

		// 전환 저장해둘 리스트
		List<TurnInfo> tInfo = new ArrayList<>();

		// 뱀의 방향 전환 횟수 입력
		int turnCount = Integer.parseInt(br.readLine());
		// 전환 타이밍과 방향 입력
		for (int i = 0; i < turnCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int timing = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			TurnInfo t = new TurnInfo(timing, dir);
			tInfo.add(t);
		}

		// 게임 시간
		int time = 0;

		// 뱀의 초기 위치 설정
		d[0][0] = 1;
		int headX = 0, headY = 0;

		// 뱀의 몸통 좌표를 저장할 덱
		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] { 0, 0 });

		// 현재 확인할 명령 인덱스 번호
		int idx = 0;

		// 뱀 이동 시뮬레이션
		while (true) {
			// 방향 전환 타이밍에 방향 전환하기
			if (idx < tInfo.size() && tInfo.get(idx).timing == time) {
				// 시계방향 전환
				if (tInfo.get(idx).dir.equals("L")) {
					direction = (direction + 3) % 4;
				}
				// 반시계방향 전환
				else {
					direction = (direction + 1) % 4;
				}

				idx++;
			}

			// 이동할 칸 좌표
			int nx = headX + dx[direction];
			int ny = headY + dy[direction];

			// 이동할 칸이 벽이거나 자기 자신이면 종료
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || d[nx][ny] == 1) {
				time++;
				break;
			}

			// 시간 증가
			time++;

			// 만약 이동할 칸에 사과가 있다면
			if (d[nx][ny] == -1) {
				d[nx][ny] = 1;
				snake.addLast(new int[] { nx, ny });
			}
			// 사과가 없다면
			else {
				d[nx][ny] = 1;
				snake.addLast(new int[] { nx, ny });
				int[] tail = snake.pollFirst();
				d[tail[0]][tail[1]] = 0;
			}
			headX = nx;
			headY = ny;
		}

		// 답 출력하기
		System.out.print(time);
	}
}

class TurnInfo {
	int timing;
	String dir;

	public TurnInfo(int timing, String dir) {
		this.timing = timing;
		this.dir = dir;
	}
}