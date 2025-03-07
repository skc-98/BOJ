import java.util.*;
import java.io.*;

public class Main {
	// 탐색 방향
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 그림의 상태 입력
		char[][] d = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 각 색상의 영역을 카운트할 변수
		int rcount = 0;
		int gcount = 0;
		int bcount = 0;

		// 색약을 가진 사람이 보는 영역을 카운트할 변수
		int rgcount = 0;

		// 방문 처리 배열
		boolean[][] visit = new boolean[n][n];
		boolean[][] visit2 = new boolean[n][n];

		// 영역을 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 아직 방문하지 않은 칸이면
				if (!visit[i][j]) {
					// 무슨 색인지 확인
					char type = d[i][j];

					// 색에 맞는 카운트 증가
					if (type == 'R') {
						rcount++;
					} else if (type == 'G') {
						gcount++;
					} else if (type == 'B') {
						bcount++;
					}

					// 이제 해당 칸을 큐에 넣고 BFS 탐색
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] { i, j });
					visit[i][j] = true;

					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							// 범위 초과, 방문 확인, 같은 색인지 확인
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] != type)
								continue;

							// 계속 BFS 탐색 진행
							q.add(new int[] { nx, ny });
							visit[nx][ny] = true;
						}
					}

				}
				// 적록색약용 BFS
				if (!visit2[i][j]) {
					// 색 확인
					char type = d[i][j];

					// 색에 맞게 카운트
					if (type == 'R' || type == 'G')
						rgcount++;

					// 이제 해당 칸을 큐에 넣고 BFS 탐색
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] { i, j });
					visit2[i][j] = true;

					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							// 범위 초과, 방문 확인, 같은 색인지 확인
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit2[nx][ny])
								continue;
							if (type == 'B') {
								if (d[nx][ny] != 'B')
									continue;
							} else {
								if (d[nx][ny] == 'B')
									continue;
							}

							// 계속 BFS 탐색 진행
							q.add(new int[] { nx, ny });
							visit2[nx][ny] = true;
						}
					}
				}
			}
		}
		// 적록 색약이 아닌 사람이 보는 구역의 수
		System.out.print(rcount + gcount + bcount);
		System.out.print(" ");
		// 적록 색약인 사람이 보는 구역의 수
		System.out.println(rgcount + bcount);
	}
}
