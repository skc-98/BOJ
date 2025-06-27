import java.util.*;
import java.io.*;

public class Main {
	// 스도쿠 저장할 배열
	static int[][] d;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열 할당
		d = new int[9][9];

		// 스도쿠 입력
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 백트래킹 시작
		backTracking(0, 0);
	}

	// 스도쿠 메서드
	static void backTracking(int x, int y) {
		// 끝까지 도달했을 경우 답 출력하고 종료
		if (y == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(d[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		// 수를 찾아야 하는 경우
		if (d[x][y] == 0) {
			// 수 하나씩 집어넣기
			for (int i = 1; i <= 9; i++) {
				if (isValid(x, y, i)) {
					d[x][y] = i;

					// 한줄 다 봤으면 다음줄
					if (x == 8)
						backTracking(0, y + 1);
					// 아니면 다음 칸
					else
						backTracking(x + 1, y);

					// 백트래킹을 위해 원상복구
					d[x][y] = 0;
				}
			}
		} else {
			if (x == 8)
				backTracking(0, y + 1);
			else
				backTracking(x + 1, y);
		}
	}

	// 가능한지 확인하는 메서드
	static boolean isValid(int row, int col, int num) {
		// 행, 열 확인
		for (int i = 0; i < 9; i++) {
			if (d[row][i] == num || d[i][col] == num)
				return false;
		}

		// 3x3 박스 확인
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (d[i][j] == num)
					return false;
			}
		}
		return true;
	}
}
