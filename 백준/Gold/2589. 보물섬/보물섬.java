import java.util.*;
import java.io.*;

// 아이디어
// 보물은 육지에서 가장 멀리 떨어진 두 곳에 묻혀있음
// BFS 탐색을 통해 가장 멀리 떨어진 두 곳이 보물의 위치고 해당하는 거리가 답
public class Main {
	// 4 방향
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 지도의 상태를 저장할 배열
		char[][] d = new char[n][m];

		// 지도의 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// BFS 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 육지로부터 시작
				if (d[i][j] == 'L') {
					// 방문처리를 위한 배열을 생성 및 -1로 초기화
					int[][] visit = new int[n][m];
					for (int ii = 0; ii < n; ii++) {
						Arrays.fill(visit[ii], -1);
					}
					// BFS 탐색을 위한 큐, 시작점 삽입 방문 처리
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] { i, j });
					visit[i][j] = 0;

					// 큐가 빌때까지 탐색
					while (!q.isEmpty()) {
						// 큐 맨 앞 요소 꺼내기
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							// 범위 초과, 방문 체크, 육지 체크
							if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] != -1 || d[nx][ny] != 'L')
								continue;
							q.add(new int[] { nx, ny });
							visit[nx][ny] = visit[x][y] + 1;
							// 여기서 최댓값 확인 및 갱신
							ans = Math.max(ans, visit[nx][ny]);
						}
					}
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
