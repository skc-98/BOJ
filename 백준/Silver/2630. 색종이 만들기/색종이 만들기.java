import java.util.*;
import java.io.*;

// 아이디어
// 색종이를 4분할 하면서 하나의 색인지 확인하고, 해당하는 색 카운트하면 됨
public class Main{
	// 한 변의 길이 n
	static int n;

	// 종이의 상태를 입력받을 배열
	static int[][] d;

	// 하얀색 종이, 파란색 종이의 수
	static int white, blue;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 한 변의 길이 입력
		n = Integer.parseInt(br.readLine());

		// 배열 초기화
		d = new int[n][n];

		// 전체 종이의 상태 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 분할 정복 시작
		white = 0;
		blue = 0;
		backTracking(0, 0, n);

		// 답 출력하기
		System.out.println(white);
		System.out.print(blue);
	}

	// 분할 정복 메서드
	static void backTracking(int row, int col, int size) {
		// 같은 색인지 확인해서 카운트
		int color = d[row][col];
		if (colorCheck(row, col, size, color)) {
			if (color == 1)
				blue++;
			else
				white++;
			return;
		}

		// 4분할 진행
		int nextSize = size / 2;
		backTracking(row, col, nextSize);
		backTracking(row, col + nextSize, nextSize);
		backTracking(row + nextSize, col, nextSize);
		backTracking(row + nextSize, col + nextSize, nextSize);
	}

	// 하나의 색인지 확인
	static boolean colorCheck(int row, int col, int size, int color) {
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (d[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
