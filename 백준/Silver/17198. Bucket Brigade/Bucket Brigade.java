import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 시작 좌표랑 최종 목적지, 방문 배열 생성
		int sx = 0, sy = 0, ex = 0, ey = 0;
		int[][] visit = new int[10][10];
		for (int i = 0; i < 10; i++) {
			Arrays.fill(visit[i], -1);
		}

		// 격자 입력
		char[][] d = new char[10][10];
		for (int i = 0; i < 10; i++) {
			String s = br.readLine();
			for (int j = 0; j < 10; j++) {
				d[i][j] = s.charAt(j);
				// 헛간일 경우
				if (s.charAt(j) == 'B') {
					ex = i;
					ey = j;
				}
				// 호수일 경우
				if (s.charAt(j) == 'L') {
					sx = i;
					sy = j;
				}
			}
		}

		// BFS 돌리기
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { sx, sy });
		visit[sx][sy] = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			// 4방 탐색
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 방문 검사, 범위 검사, 바위 검사
				if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10 || visit[nx][ny] > -1 || d[nx][ny] == 'R')
					continue;

				// 다음 좌표 넣으면서 값 더해두기
				q.add(new int[] { nx, ny });
				visit[nx][ny] = visit[x][y] + 1;
			}
		}

		// 답 출력하기
		System.out.println(visit[ex][ey] - 1);
	}
}
