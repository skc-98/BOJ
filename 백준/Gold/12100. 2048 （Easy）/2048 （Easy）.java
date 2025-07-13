import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언부
	static int n;
	static int[][] d;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드의 크기 입력
		n = Integer.parseInt(br.readLine());

		// 보드의 상태 저장할 배열
		d = new int[n][n];

		// 보드의 상태 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 중복조합
		backTracking(0);

		// 답 출력하기
		System.out.println(ans);
	}

	// 중복조합 메서드
	static void backTracking(int moveCount) {
		if (moveCount == 5) {
			// 현재 보드에서 가장 큰 값 갱신
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ans = Math.max(ans, d[i][j]);
				}
			}
			return;
		}

		// 현재 보드 상태 복사하기
		int[][] backup = copyBoard();

		// 4방향 시도
		up();
		backTracking(moveCount + 1);
		restoreBoard(backup);

		down();
		backTracking(moveCount + 1);
		restoreBoard(backup);

		left();
		backTracking(moveCount + 1);
		restoreBoard(backup);

		right();
		backTracking(moveCount + 1);
		restoreBoard(backup);
	}

	// 현재 보드 상태 복사
	static int[][] copyBoard() {
		int[][] newBoard = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(d[i], 0, newBoard[i], 0, n);
		}
		return newBoard;
	}

	// 보드 상태 복원
	static void restoreBoard(int[][] backup) {
		for (int i = 0; i < n; i++) {
			System.arraycopy(backup[i], 0, d[i], 0, n);
		}
	}

	// 위로 이동하는 메서드
	static void up() {
		for (int j = 0; j < n; j++) {
			int[] line = new int[n];
			int idx = 0;
			boolean merged = false;

			for (int i = 0; i < n; i++) {
				if (d[i][j] == 0)
					continue;

				if (line[idx] == 0) {
					line[idx] = d[i][j];
					merged = false;
				} else if (line[idx] == d[i][j] && !merged) {
					line[idx] *= 2;
					merged = true;
				} else {
					idx++;
					line[idx] = d[i][j];
					merged = false;
				}
			}

			for (int i = 0; i < n; i++) {
				d[i][j] = line[i];
			}
		}
	}

	// 아래로 이동하는 메서드
	static void down() {
		for (int j = 0; j < n; j++) {
			int[] line = new int[n];
			int idx = n - 1;
			boolean merged = false;

			for (int i = n - 1; i >= 0; i--) {
				if (d[i][j] == 0)
					continue;

				if (line[idx] == 0) {
					line[idx] = d[i][j];
					merged = false;
				} else if (line[idx] == d[i][j] && !merged) {
					line[idx] *= 2;
					merged = true;
				} else {
					idx--;
					line[idx] = d[i][j];
					merged = false;
				}
			}

			for (int i = 0; i < n; i++) {
				d[i][j] = line[i];
			}
		}
	}

	// 오른쪽으로 이동하는 메서드
	static void right() {
		for (int i = 0; i < n; i++) {
			int[] line = new int[n];
			int idx = n - 1;
			boolean merged = false;

			for (int j = n - 1; j >= 0; j--) {
				if (d[i][j] == 0)
					continue;

				if (line[idx] == 0) {
					line[idx] = d[i][j];
					merged = false;
				} else if (line[idx] == d[i][j] && !merged) {
					line[idx] *= 2;
					merged = true;
				} else {
					idx--;
					line[idx] = d[i][j];
					merged = false;
				}
			}

			for (int j = 0; j < n; j++) {
				d[i][j] = line[j];
			}
		}
	}

	// 왼쪽으로 이동하는 메서드
	static void left() {
		for (int i = 0; i < n; i++) {
			int[] line = new int[n];
			int idx = 0;
			boolean merged = false;

			for (int j = 0; j < n; j++) {
				if (d[i][j] == 0)
					continue;

				if (line[idx] == 0) {
					line[idx] = d[i][j];
					merged = false;
				} else if (line[idx] == d[i][j] && !merged) {
					line[idx] *= 2;
					merged = true;
				} else {
					idx++;
					line[idx] = d[i][j];
					merged = false;
				}
			}

			for (int j = 0; j < n; j++) {
				d[i][j] = line[j];
			}
		}
	}

}
