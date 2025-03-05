import java.util.*;
import java.io.*;

// 아이디어
public class Main {
	// 체스판의 크기 n
	static int n;

	// 말을 놓을 수 있는지 확인하기 위한 배열
	static boolean[] col;
	static boolean[] leftcross;
	static boolean[] rightcross;

	// 답을 저장할 변수
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 체스판의 크기 입력
		n = Integer.parseInt(br.readLine());

		// 공격 배열 초기화
		col = new boolean[n];
		leftcross = new boolean[2 * n - 1];
		rightcross = new boolean[2 * n - 1];

		// 여왕을 놓는 메서드 호출
		backTracking(0);

		// 답 출력하기
		System.out.println(ans);
	}

	// 여왕을 배치하는 경우의 수를 세는 메서드
	static void backTracking(int row) {
		// 마지막 열까지 놓고 다시 호출시 가능한 경우임
		if (row == n) {
			ans++;
			return;
		}

		// 함수 호출하면 해당 말에서 공격 가능한 위치 처리
		for (int i = 0; i < n; i++) {
			// 불가능한 자리라면 다음 칸 시도
			if (col[i] || leftcross[row - i + n - 1] || rightcross[row + i]) {
				continue;
			}

			// 가능한 경우면 말 놓기
			col[i] = true;
			leftcross[row - i + n - 1] = true;
			rightcross[row + i] = true;

			// 말을 놓고 다음 줄 호출
			backTracking(row + 1);

			// 백트래킹을 위해 다시 원상복구
			col[i] = false;
			leftcross[row - i + n - 1] = false;
			rightcross[row + i] = false;
		}
	}
}
