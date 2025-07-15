import java.util.*;
import java.io.*;

public class Main {
	// 도시의 크기, 찾는 위치 저장할 변수
	static int N, row, col;

	// 순서 카운트할 값
	static int ans = -1;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		// 분할정복 메서드 호출
		int t = (int) Math.pow(2, N);
		dc(0, 0, t);
	}

	// 분할정복 메서드
	static void dc(int x, int y, int n) {
		// 변의 길이가 2까지 줄면 카운트
		if (n == 2) {
			sequence(x, y);
			return;
		}

		// 재귀 호출
		int half = n / 2;
		int value = half * half;

		// 제 1 영역 확인
		if (col < x + half || row < y + half) {
			dc(x, y, half);
		} else {
			ans += value;
		}

		// 제 2 영역 확인
		if (col >= x + half || row < y + half) {
			dc(x + half, y, half);
		} else {
			ans += value;
		}

		// 제 3 영역 확인
		if (col < x || row >= y + half) {
			dc(x, y + half, half);
		} else {
			ans += value;
		}

		// 제 4 영역 확인
		if (col >= x + half && row >= y + half) {
			dc(x + half, y + half, half);
		} else {
			ans += value;
		}
	}

	// 순서 카운트할 메서드
	static void sequence(int x, int y) {
		add(x, y);
		add(x + 1, y);
		add(x, y + 1);
		add(x + 1, y + 1);
	}

	// 값 증가시키는 메서드
	static void add(int x, int y) {
		// 카운팅
		ans++;

		// 해당 칸 찾으면 종료
		if (x == col && y == row) {
			System.out.println(ans);
			System.exit(0);
		}
		return;
	}
}
