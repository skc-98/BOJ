import java.util.*;
import java.io.*;

public class Main {
	// 영상의 크기
	static int N;

	// 저장할 배열
	static char[][] d;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 영상 크기 입력
		N = Integer.parseInt(br.readLine());

		// 배열 할당
		d = new char[N][N];

		// 영상 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 분할 정복 호출
		dc(0, 0, N);
	}

	// 분할 정복 메서드
	static void dc(int x, int y, int n) {
		// 해당 영역 확인하고 맞으면 영역 숫자 출력하기
		if (checkArea(x, y, n)) {
			System.out.print(d[x][y]);
			return;
		}

		// 아니면 재귀호출
		int half = n / 2;
		System.out.print("(");
		dc(x, y, half);
		dc(x, y + half, half);
		dc(x + half, y, half);
		dc(x + half, y + half, half);
		System.out.print(")");
	}

	// 해당 영역이 같은 수인지 확인하는 메서드
	static boolean checkArea(int x, int y, int n) {
		char value = d[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (d[i][j] != value)
					return false;
			}
		}
		return true;
	}
}
