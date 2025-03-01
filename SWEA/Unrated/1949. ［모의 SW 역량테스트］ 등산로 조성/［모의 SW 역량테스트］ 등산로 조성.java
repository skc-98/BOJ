import java.util.*;
import java.io.*;

// 아이디어
// 가장 높은 봉우리에서 DFS 탐색을 통해 경로를 탐색하고
// 높은 봉우리를 만났을 때 k만큼 깎아서 탐색이 가능한 모든 경우를 확인하고 최장 경로면 갱신해 줬습니다.
// 시간제한: 51개 테스트케이스 합쳐서 3초, 메모리제한: 256MB
public class Solution {
	// 탐색 가능한 방향
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 지도의 크기
	static int n;

	// 깎을 수 있는 깊이
	static int k;

	// 지도의 정보를 입력할 배열
	static int[][] d;

	// 방문 여부 배열
	static boolean[][] visit;

	// 답을 저장할 변수
	static int ans;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 각 테스트 케이스마다 ans 초기화
			ans = 0;

			// 지도의 크기와 깎을 수 있는 깊이 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			// 지도 정보 입력, 시작점이 될 가장 높은 봉우리 찾기
			d = new int[n][n];
			visit = new boolean[n][n];
			int maxHeight = 0;
			List<int[]> highMount = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
					// 더 높은 봉우리 찾으면 높이 갱신하고 리스트 비우고 새 봉우리만 입력
					if (d[i][j] > maxHeight) {
						maxHeight = d[i][j];
						highMount.clear();
						highMount.add(new int[] { i, j });
					}
					// 가장 높은 봉우리가 여러개면 리스트에 그냥 추가
					else if (d[i][j] == maxHeight) {
						highMount.add(new int[] { i, j });
					}
				}
			}

			// 시작 봉우리에서 DFS 탐색 시작
			for (int i = 0; i < highMount.size(); i++) {
				// 시작 봉우리의 x,y 좌표
				int x = highMount.get(i)[0];
				int y = highMount.get(i)[1];

				// 방문처리
				visit[x][y] = true;

				// DFS 메서드 호출
				dfs(x, y, 1, false);

				// 방문 처리 복구
				visit[x][y] = false;
			}

			// 답 출력하기
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	// DFS 탐색을 통해 최장 길이 경로를 찾는 메서드
	static void dfs(int x, int y, int length, boolean cut) {
		// 최장 경로일 시 갱신
		ans = Math.max(ans, length);

		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 초과, 방문 체크
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
				continue;

			// 높이가 낮아서 이동 가능한 경우면 그냥 이동
			if (d[nx][ny] < d[x][y]) {
				// 방문 처리하면서 이동
				visit[nx][ny] = true;
				dfs(nx, ny, length + 1, cut);

				// 탐색 끝나고 돌아오면 방문 처리 취소
				visit[nx][ny] = false;
			}
			// 깎아서 이동 가능한 경우면 깎아서 탐색 해보기
			else if (!cut && d[nx][ny] - k < d[x][y]) {
				// 탐색 종료 후 다시 원래 높이를 주기 위해 원래 값 저장해두기
				int temp = d[nx][ny];

				// 봉우리 깎기 ==> 여기서 d[x][y]-k로 진행했지만 1만큼 낮은 높이로만 깎아야 함
				// 이것때문에 첫 제출때 틀림
				d[nx][ny] = d[x][y] - 1;

				// 방문 처리 후 DFS 탐색, 이때 깎았으니까 cut->true로 변환 주의(이거 cut으로 뒀다가 헤맸음;)
				visit[nx][ny] = true;
				dfs(nx, ny, length + 1, true);

				// 방문 처리 취소, 원래 높이로 복구
				visit[nx][ny] = false;
				d[nx][ny] = temp;
			}
		}
	}
}
