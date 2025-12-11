import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언부
	static int n;
	static int[][] d;
	static int countMinus = 0;
	static int countZero = 0;
	static int countOne = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기 입력, 배열 할당
		n = Integer.parseInt(br.readLine());
		d = new int[n][n];

		// 종이 상태 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 분할 정복 시작
		dq(0, 0, n);

		// 답 출력하기
		System.out.println(countMinus);
		System.out.println(countZero);
		System.out.println(countOne);
	}

	// 분할 정복 메서드
	static void dq(int x, int y, int size) {
		// 현재 사이즈로 조건 체크
		boolean isPaper = true;
		int now = d[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (now != d[i][j]) {
					isPaper = false;
				}
			}
		}

		// 만약 종이가 하나로 되어있으면 종료
		if (isPaper) {
			if (now == -1)
				countMinus++;
			else if (now == 0)
				countZero++;
			else if (now == 1)
				countOne++;
			return;
		}

		// 분할 호출
		int nextSize = size / 3;
		dq(x, y, nextSize);
		dq(x, y + nextSize, nextSize);
		dq(x, y + 2 * nextSize, nextSize);
		dq(x + nextSize, y, nextSize);
		dq(x + nextSize, y + nextSize, nextSize);
		dq(x + nextSize, y + 2 * nextSize, nextSize);
		dq(x + 2 * nextSize, y, nextSize);
		dq(x + 2 * nextSize, y + nextSize, nextSize);
		dq(x + 2 * nextSize, y + 2 * nextSize, nextSize);
	}
}
