import java.util.*;
import java.io.*;

public class Main {
	// 4방 벡터
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 배열
		int[][] d = new int[n][m];

		// 배열 채우기
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d[i][j] = s.charAt(j) - '0';
			}
		}

		// 색 바꿀 좌표랑 값
		st = new StringTokenizer(br.readLine());
		int changeX = Integer.parseInt(st.nextToken());
		int changeY = Integer.parseInt(st.nextToken());
		int changeValue = Integer.parseInt(st.nextToken());

		// 첫 색상 기억하기
		int color = d[changeX][changeY];

		// BFS용 큐, 방문배열
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];

		// 첫 요소 삽입
		q.add(new int[] { changeX, changeY });
		visit[changeX][changeY] = true;
		d[changeX][changeY] = changeValue;

		// 해당 좌표부터 BFS로 플러드 필
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위검사 방문체크
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
					continue;
				}

				// 원래 색과 같을때만
				if (d[nx][ny] != color)
					continue;

				// 아직아니면 큐에넣고 배열바꾸고 방문처리
				q.add(new int[] { nx, ny });
				visit[nx][ny] = true;
				d[nx][ny] = changeValue;
			}
		}

		// 최종 상태 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(d[i][j]);
			}
			System.out.println();
		}
	}
}
