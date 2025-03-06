import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import java.io.*;

public class Solution {
	// 4방향 정의
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	// 맵의 높이와 너비를 저장할 변수
	static int w, h;

	// 맵의 상태를 저장할 배열
	static char[][] map;

	// 전차의 좌표와 방향을 저장해둘 변수
	static int x, y, direction;

	// 명령 문자열과 길이를 저장할 변수
	static int orderLength;
	static String order;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 맵의 높이와 너비 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			// 맵의 상태 입력
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String mapRow = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = mapRow.charAt(j);
					// 만약 전차라면 좌표와 시작 방향을 저장, 0이 오른쪽 1가 왼쪽 2이 위쪽 3가 아래쪽
					if (map[i][j] == '>') {
						x = i;
						y = j;
						direction = 0;
					} else if (map[i][j] == '<') {
						x = i;
						y = j;
						direction = 1;
					} else if (map[i][j] == '^') {
						x = i;
						y = j;
						direction = 2;
					} else if (map[i][j] == 'v') {
						x = i;
						y = j;
						direction = 3;
					}
				}
			}

			// 명령 문자열과 길이 입력
			orderLength = Integer.parseInt(br.readLine());
			order = br.readLine();

			// 명령을 수행할 함수 호출
			orderFunction();

			// 맵 출력하기
			System.out.printf("#%d ", tc);
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	// 명령을 실핼할 메서드
	static void orderFunction() {
		for (int i = 0; i < orderLength; i++) {
			// 포탄 발사 명령
			if (order.charAt(i) == 'S') {
				// 현재 전차의 좌표로부터
				int nx = x;
				int ny = y;
				// 벽을 찾거나 밖으로 나갈때까지 반복
				while (true) {
					// 밖으로 나가면 종료
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
						break;
					}
					// 벽돌벽을 찾으면 평지로 만들고 종료
					else if (map[nx][ny] == '*') {
						map[nx][ny] = '.';
						break;
					}
					// 강철벽을 만나면 바로 종료
					else if (map[nx][ny] == '#') {
						break;
					}
					// 현재 바라보는 방향으로 포탄 진행
					nx += dx[direction];
					ny += dy[direction];
				}
			} else if (order.charAt(i) == 'U') {
				// 방향을 위쪽으로
				direction = 2;
				map[x][y] = '^';

				// 만약 이동하려는 좌표값이 범위 초과하면 그냥 continue;
				if (x + dx[direction] < 0 || x + dx[direction] >= h || y + dy[direction] < 0
						|| y + dy[direction] >= w) {
					continue;
				}

				// 만약 위쪽이 평지면 해당 좌표로 이동
				if (map[x + dx[direction]][y + dy[direction]] == '.') {
					// 원래 있던자리 평지로 바꾸고 이동
					map[x][y] = '.';
					map[x + dx[direction]][y + dy[direction]] = '^';
					x += dx[direction];
					y += dy[direction];
				}

			} else if (order.charAt(i) == 'D') {
				// 방향을 아래쪽으로
				direction = 3;
				map[x][y] = 'v';

				// 만약 이동하려는 좌표값이 범위 초과하면 그냥 continue;
				if (x + dx[direction] < 0 || x + dx[direction] >= h || y + dy[direction] < 0
						|| y + dy[direction] >= w) {
					continue;
				}

				// 만약 아래쪽이 평지면 해당 좌표로 이동
				if (map[x + dx[direction]][y + dy[direction]] == '.') {
					// 원래 있던자리 평지로 바꾸고 이동
					map[x][y] = '.';
					map[x + dx[direction]][y + dy[direction]] = 'v';
					x += dx[direction];
					y += dy[direction];
				}

			} else if (order.charAt(i) == 'L') {
				// 방향을 왼쪽
				direction = 1;
				map[x][y] = '<';

				// 만약 이동하려는 좌표값이 범위 초과하면 그냥 continue;
				if (x + dx[direction] < 0 || x + dx[direction] >= h || y + dy[direction] < 0
						|| y + dy[direction] >= w) {
					continue;
				}

				// 만약 왼쪽이 평지면 해당 좌표로 이동
				if (map[x + dx[direction]][y + dy[direction]] == '.') {
					// 원래 있던자리 평지로 바꾸고 이동
					map[x][y] = '.';
					map[x + dx[direction]][y + dy[direction]] = '<';
					x += dx[direction];
					y += dy[direction];
				}
			} else if (order.charAt(i) == 'R') {
				// 방향을 오른쪽으로
				direction = 0;
				map[x][y] = '>';

				// 만약 이동하려는 좌표값이 범위 초과하면 그냥 continue;
				if (x + dx[direction] < 0 || x + dx[direction] >= h || y + dy[direction] < 0
						|| y + dy[direction] >= w) {
					continue;
				}

				// 만약 오른쪽이 평지면 해당 좌표로 이동
				if (map[x + dx[direction]][y + dy[direction]] == '.') {
					// 원래 있던자리 평지로 바꾸고 이동
					map[x][y] = '.';
					map[x + dx[direction]][y + dy[direction]] = '>';
					x += dx[direction];
					y += dy[direction];
				}
			}

//			// 명령하나 끝나면 맵 출력하기
//			System.out.printf("명령 %d 끝난 상태: \n", i + 1);
//			for (int j = 0; j < h; j++) {
//				for (int k = 0; k < w; k++) {
//					System.out.print(map[j][k] + " ");
//				}
//				System.out.println();
//			}
		}
	}
}
