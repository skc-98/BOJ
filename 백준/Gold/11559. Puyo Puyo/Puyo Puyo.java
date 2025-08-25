import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열
		char[][] d = new char[12][6];

		// 입력
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 답 변수
		int ans = 0;

		// 계속 반복하기
		while (true) {
			// BFS 용 큐와 방문 배열
			boolean bomb = false;
			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visit = new boolean[12][6];

			// 연쇄 여부 확인하기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					// 존재하는 칸이면
					if (d[i][j] != '.' && !visit[i][j]) {
						// 몇개짜리 묶음인지, 터트릴 위치는 저장해두기
						int count = 1;
						List<int[]> point = new ArrayList<>();
						q.add(new int[] { i, j, d[i][j] });
						point.add(new int[] { i, j });
						visit[i][j] = true;

						// BFS 탐색 시작
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.peek()[1];
							char color = (char) q.peek()[2];
							q.poll();

							// 4방 탐색
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];

								// 범위 초과, 방문 검사
								if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visit[nx][ny])
									continue;

								// 아니면 큐에 추가하고 카운트 증가 및 좌표 저장4
								if (d[nx][ny] == color) {
									q.add(new int[] { nx, ny, color });
									point.add(new int[] { nx, ny });
									count++;
									visit[nx][ny] = true;
								}
							}
						}

						// BFS 돌고 터트릴 수 있는 경우 터트리기
						if (count >= 4) {
							bomb = true;
							for (int k = 0; k < point.size(); k++) {
								d[point.get(k)[0]][point.get(k)[1]] = '.';
							}
						}
					}
				}
			}

			// 연쇄가 일어났을 경우 중력 구현
			if (bomb) {
				// 답 증가
				ans++;

				// 중력 구현
				for (int j = 0; j < 6; j++) {
					int empty = 11;
					for (int i = 11; i >= 0; i--) {
						if (d[i][j] != '.') {
							char temp = d[i][j];
							d[i][j] = '.';
							d[empty][j] = temp;
							empty--;
						}
					}
				}
			}

			// 연쇄가 일어나지 않았다면 종료
			else
				break;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
