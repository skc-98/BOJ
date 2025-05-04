import java.util.*;
import java.io.*;

public class Main {
	// 탐색을 위한 방향 설정
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 지도를 저장해 둘 배열
		char[][] d = new char[n][n];

		// 지도의 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// BFS 탐색을 위한 큐, 배열 생성
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[n][n];

		// visit 배열 최댓값으로 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}

		// 시작점 좌표 넣기
		q.add(new int[] { 0, 0, 0 });

		// 큐가 빌때까지 BFS 탐색
		while (!q.isEmpty()) {
			// 맨 앞 요소 꺼내기
			int x = q.peek()[0];
			int y = q.peek()[1];
			int count = q.peek()[2];
			q.poll();

			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				// 다음 좌표 값
				int nx = x + dx[i];
				int ny = y + dy[i];
				int ncount = count;

				// 범위 초과 체크
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				// 이동하려는 칸이 검은색이면
				if (d[nx][ny] == '0')
					ncount++;

				// 만약 다음 이동에 지금까지보다 많은 벽을 부수지 않는 경우만 큐에 추가
				if (ncount < visit[nx][ny]) {
					q.add(new int[] { nx, ny, ncount });
					visit[nx][ny] = ncount;
				}
			}
		}

		// 답 출력하기
		System.out.println(visit[n - 1][n - 1]);
	}
}
