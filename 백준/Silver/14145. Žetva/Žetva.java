import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 영역 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 배열 생성
		int[][] d = new int[n][m];

		// 배열 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j) - '0';
			}
		}

		// BFS 용 방문 배열과 큐
		boolean[][] visit = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();

		// 각 구역의 좌표 목록과 크기 저장
		List<List<int[]>> areas = new ArrayList<>();
		List<Integer> sizes = new ArrayList<>();

		// 모든 칸 돌면서
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] != 0 && !visit[i][j]) {
					q.add(new int[] { i, j });
					visit[i][j] = true;

					List<int[]> cells = new ArrayList<>();
					cells.add(new int[] { i, j });
					int count = 1;

					// BFS 시작
					while (!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						q.poll();

						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || d[nx][ny] == 0)
								continue;
							visit[nx][ny] = true;
							count++;
							q.add(new int[] { nx, ny });
							cells.add(new int[] { nx, ny });
						}
					}

					// 구역 정보 저장
					areas.add(cells);
					sizes.add(count);
				}
			}
		}

		// 구역들을 크기 기준으로 정렬
		Integer[] idx = new Integer[areas.size()];
		for (int i = 0; i < idx.length; i++)
			idx[i] = i;
		Arrays.sort(idx, Comparator.comparingInt(sizes::get));

		// 결과 배열
		int[][] result = new int[n][m];

		// 수확일자
		int day = 1;
		for (int id : idx) {
			for (int[] cell : areas.get(id)) {
				int x = cell[0];
				int y = cell[1];
				result[x][y] = day;
			}
			day++;
		}

		// 답 출력하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
