import java.util.*;
import java.io.*;

public class Main {
	// 스도쿠 판의 정보를 저장할 배열
	static int[][] d;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스도쿠 판에 정보 입력하기
		d = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d[i][j] = s.charAt(j) - '0';
			}
		}

		// 스도쿠 완성하기
		findNum(0, 0);
	}

	static void findNum(int i, int j) {
		// 해당 행 끝까지 확인했으면 다음 열로 이동
		if (j == 9) {
			findNum(i + 1, 0);
			return;
		}

		// 모든 칸 확인했으면 출력하고 종료
		if (i == 9) {
			for (int ii = 0; ii < 9; ii++) {
				for (int jj = 0; jj < 9; jj++) {
					System.out.print(d[ii][jj]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		// 현재 칸이 0이면
		if (d[i][j] == 0) {
			// 1~9까지 가능한지 확인
			for (int k = 1; k <= 9; k++) {
				// 가능한 숫자를 찾았으면
				if (rowCheck(k, i, j) && colCheck(k, i, j) && blockCheck(k, i, j)) {
					// 해당 칸 해당 숫자로 채우고 다음 칸 호출
					d[i][j] = k;
					findNum(i, j + 1);
				}
				d[i][j] = 0;
			}
		} else {
			findNum(i, j + 1);
		}
	}

	// 행 체크하는 메서드
	static boolean colCheck(int n, int row, int col) {
		for (int i = 0; i < 9; i++) {
			if (d[i][col] == n)
				return false;
		}
		return true;
	}

	// 열 체크하는 메서드
	static boolean rowCheck(int n, int row, int col) {
		for (int i = 0; i < 9; i++) {
			if (d[row][i] == n)
				return false;
		}
		return true;
	}

	// 블럭 체크하는 메서드
	static boolean blockCheck(int n, int row, int col) {
		int x = (row / 3) * 3;
		int y = (col / 3) * 3;
		for (int i = x; i <= x + 2; i++) {
			for (int j = y; j <= y + 2; j++) {
				if (d[i][j] == n)
					return false;
			}
		}
		return true;
	}
}