import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] li = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				li[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 정답이 될 연차 수
		int ans = 0;
		boolean[][] visit=new boolean[n][m];
		while (true) {
			ans++;

			// 얼음이 녹는 구현부
			int[][] iceblock = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (li[i][j] != 0) {
						int emptyCount = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (nx < 0 || nx >= n || ny < 0 || ny >= m)
								continue;
							if (li[nx][ny] == 0)
								emptyCount++;
						}
						iceblock[i][j] = emptyCount;
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(li[i][j]!=0) {
						li[i][j]=Math.max(0, li[i][j] - iceblock[i][j]);
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
                Arrays.fill(visit[i], false);
            }

			// 얼음이 두 덩이인지 확인하는 구현부(bfs 구현)
			int bcount = 0;
			Queue<Point> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (li[i][j] != 0 && !visit[i][j]) {
						bcount++;
						visit[i][j] = true;
						q.add(new Point(i, j));
						while (!q.isEmpty()) {
							Point front = q.poll();
							for (int k = 0; k < 4; k++) {
								int mx = front.x + dx[k];
								int my = front.y + dy[k];
								if (mx < 0 || mx >= n || my < 0 || my >= m || visit[mx][my])
									continue;
								if (li[mx][my] != 0) {
									q.add(new Point(mx, my));
									visit[mx][my]=true;
								}
							}
						}
					}
				}
			}
			if (bcount == 0) {
				ans = 0;
				break;
			} else if (bcount >= 2) {
				break;
			}
		}
		System.out.println(ans);
	}
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}