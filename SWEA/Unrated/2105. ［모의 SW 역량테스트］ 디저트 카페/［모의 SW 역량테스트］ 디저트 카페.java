import java.util.*;
import java.io.*;

// 조건 1. 대각선 방향으로 움직여서 사각형 모양을 그리며 출발한 카페로 돌아와야함
// 조건 2. 이동 방향에 같은 숫자를 가진 디저트가 있으면 안된다.
// 조건 3. 하나의 카페에서 디저트를 먹고 끝내도 안됨
// 조건 4. 방문한 카페를 다시 돌아가는 것도 안된다.

// 아이디어
// 디저트 시작점으로부터 하나의 방향으로 고정된 마름모를 DFS 탐색을 통해 모두 구하고 불가능한 경우는 가지치기 했습니다.
public class Solution {
	// 마름모는 시계방향
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	// 지역의 크기
	static int n;

	// 지역의 디저트 정보 저장할 배열
	static int[][] desert;

	// 답을 저장할 변수
	static int ans;

	// 시작점으로 돌아온건지 확인하기 위한 변수
	static int startX, startY;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 테스트 케이스 시작 시 초기화
			ans = 0;

			// 지역의 한 변의 길이 입력
			n = Integer.parseInt(br.readLine());

			// n*n 크기의 디저트 종류 정보 입력
			desert = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					desert[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 디저트 시작점에서 무조건 한 방향으로 탐색하도록 고정 DFS 탐색을 통해 모든 마름모 구하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 4개의 꼭짓점에 위치하면 불가능하니까 건너뛰기
					if (i == 0 && j == 0)
						continue;
					else if (i == n - 1 && j == 0)
						continue;
					else if (i == 0 && j == n - 1)
						continue;
					else if (i == n - 1 && j == n - 1)
						continue;

					// 시작 좌표는 저장해두고, DFS 탐색 시작
					startX = i;
					startY = j;
					visit.clear();
					visit.add(desert[i][j]);
					dfs(i, j, 1, 0);
				}
			}

			// 답 출력하기, 디저트를 먹을 수 없는 경우에 -1
			if (ans == 0) {
				System.out.printf("#%d %d\n", tc, -1);
				continue;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	// 방문한 디저트 가게면 가지치기 하기 위한 set
	static Set<Integer> visit = new HashSet<>();

	// DFS 탐색을 통해 가능한 모든 마름모 경로 구하기
	static void dfs(int x, int y, int count, int d) {
		// 모든 가능한 방향 전환: 현재 방향 d부터 3까지
		for (int i = d; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 체크
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			// 시작점으로 돌아오면 값 비교 후 갱신
			if (nx == startX && ny == startY && count >= 4) {
				ans = Math.max(ans, count);
				continue;
			}

			// 이미 먹은 디저트 번호이면 진행 불가
			if (visit.contains(desert[nx][ny]))
				continue;

			// 방문 처리 후 재귀 호출
			visit.add(desert[nx][ny]);
			dfs(nx, ny, count + 1, i);
			visit.remove(desert[nx][ny]);
		}
	}
}