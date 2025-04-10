import java.util.*;
import java.io.*;

// 아이디어
// BFS 탐색을 통해 국경을 이어주고 모든 이동이 끝날때까지 반복해주면 됨
public class Main {
	// 방향 설정
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 땅의 크기, 인구 차이 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		// 각 나라의 인구수를 저장할 배열
		int[][] d = new int[n][n];

		// n*n 크기의 각 나라에 인구수 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 여기서부터 while 돌리면 됨
		while (true) {
			// 종료 조건을 위한 논리형 변수
			boolean check = false;

			// 방문 처리를 위한 배열
			boolean[][] visit = new boolean[n][n];

			// 각 국가간 연결 상태를 판단하기 위한 2차원 리스트
			List<List<int[]>> list = new ArrayList<>();

			// BFS 탐색을 통해 국경이 열려 연결 된 국가를 리스트에 담기
			Queue<int[]> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 아직 확인하지 않은 국가라면
					if (!visit[i][j]) {
						// 새로운 리스트 요소 생성하고
						list.add(new ArrayList<>());

						// 리스트와 큐에 넣고 방문 처리 후 BFS 시작
						list.get(list.size() - 1).add(new int[] { i, j });
						q.add(new int[] { i, j });
						visit[i][j] = true;
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.peek()[1];
							q.poll();

							// 4방향 탐색
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];

								// 범위 초과 검사 및 방문 검사
								if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
									continue;

								// 인구 차이 검사
								int popGap = Math.abs(d[nx][ny] - d[x][y]);
								if (popGap < l || popGap > r)
									continue;

								// 큐와 리스트에 넣고 방문처리
								q.add(new int[] { nx, ny });
								list.get(list.size() - 1).add(new int[] { nx, ny });
								visit[nx][ny] = true;
							}
						}
						// 그룹에 2개 이상 국가가 있다면 인구 이동 발생
						if (list.get(list.size() - 1).size() > 1)
							check = true;
					}
				}
			}

			// 인구 이동 없으면 종료하기
			if (!check)
				break;

			// 연결 된 국가들 사이의 인구 이동
			for (int i = 0; i < list.size(); i++) {
				// 현재 연결 된 국가들 인구 합 구해서 나누기
				int sum = 0;
				for (int j = 0; j < list.get(i).size(); j++) {
					int x = list.get(i).get(j)[0];
					int y = list.get(i).get(j)[1];
					sum += d[x][y];
				}
				sum /= list.get(i).size();

				// 다시 국가에 배정하기
				for (int j = 0; j < list.get(i).size(); j++) {
					int x = list.get(i).get(j)[0];
					int y = list.get(i).get(j)[1];
					d[x][y] = sum;
				}
			}

			// 답 증가
			ans++;
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
