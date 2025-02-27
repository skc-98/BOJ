import java.util.*;
import java.io.*;

public class Main {
	// 탐색 방향은 순서대로 3가지
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	// 공간의 크기도 전역변수로 선언
	static int n, m;

	// 연결한 파이프의 수 전역변수로 선언
	static int pipe = 0;

	// 공간의 정보 또한 전역변수로 선언
	static char[][] d;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 공간의 크기만큼 할당
		d = new char[n][m];

		// n*m 크기의 공간 정보 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 각 행의 첫 번째 열에서 파이프 연결 여부 확인
		for (int i = 0; i < n; i++) {
			if (bread(i, 0))
				pipe++;
		}

		// 정답 출력하기
		System.out.println(pipe);
	}

	// 벽에 바짝 붙혀서 파이프 연결하기
	static boolean bread(int x, int y) {
		// 파이프 연결하면서 진행
		d[x][y] = 'P';

		// 3방향 탐색: 오른쪽 위, 오른쪽, 오른쪽 아래 순서대로 탐색
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 초과 체크
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			// 건물이 있어도 continue;
			if (d[nx][ny] == 'x' || d[nx][ny] == 'P')
				continue;

			// 만약 이동한 칸의 x좌표가 m-1번째 칸이면 파이프 연결 성공
			if (ny == m - 1) {
				return true;
			}

			// 다음 칸 호출
			if (bread(nx, ny))
				return true;
		}
		// 이동할 수 없으면 파이프 연결 실패
		return false;
	}
}