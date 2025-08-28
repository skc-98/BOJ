import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 색종이 배열
		int[] paper = new int[6];

		// 6종류의 색종이 수 입력
		for (int i = 0; i < 6; i++) {
			paper[i] = Integer.parseInt(br.readLine());
		}

		// 판의 크기 고정이라 수학 연산으로 가능
		// 답 변수, 가장 큰 색종이 수 더하기
		int ans = 0;
		ans += paper[5];

		// 5짜리랑 1짜리
		while (paper[4] > 0) {
			paper[4]--;
			ans++;
			paper[0] = Math.max(0, paper[0] - 11);
		}

		// 4짜리랑 2짜리, 1짜리
		while (paper[3] > 0) {
			paper[3]--;
			ans++;
			if (paper[1] > 0) {
				if (paper[1] >= 5) {
					paper[1] -= 5;
				} else {
					int pos = 5 - paper[1];
					paper[1] = 0;
					paper[0] = Math.max(0, paper[0] - pos * 4);
				}
			} else {
				paper[0] = Math.max(0, paper[0] - 20);
			}
		}

		// 3짜리랑 2짜리, 1짜리
		while (paper[2] > 0) {
			if (paper[2] >= 4) {
				ans++;
				paper[2] -= 4;
			} else {
				if (paper[2] == 1) {
					if (paper[1] >= 5) {
						paper[1] = Math.max(0, paper[1] - 5);
						paper[0] = Math.max(0, paper[0] - 7);
					} else {
						int pos = 5 - paper[1];
						paper[1] = 0;
						paper[0] = Math.max(0, paper[0] - (7 + pos * 4));
					}
				} else if (paper[2] == 2) {
					if (paper[1] >= 3) {
						paper[1] = Math.max(0, paper[1] - 3);
						paper[0] = Math.max(0, paper[0] - 6);
					} else {
						int pos = 3 - paper[1];
						paper[1] = 0;
						paper[0] = Math.max(0, paper[0] - (6 + pos * 4));
					}
				} else if (paper[2] == 3) {
					if (paper[1] >= 1) {
						paper[1] = Math.max(0, paper[1] - 1);
						paper[0] = Math.max(0, paper[0] - 5);
					} else {
						int pos = 1 - paper[1];
						paper[1] = 0;
						paper[0] = Math.max(0, paper[0] - (5 + pos * 4));
					}
				}
				ans++;
				paper[2] = 0;
			}
		}

		// 2짜리 1짜리
		while (paper[1] > 0) {
			if (paper[1] >= 9) {
				ans++;
				paper[1] -= 9;
			} else {
				ans++;
				int pos = 9 - paper[1];
				paper[1] = 0;
				paper[0] = Math.max(0, paper[0] - (4 * pos));
			}
		}

		// 나머지 1짜리
		while (paper[0] > 0) {
			paper[0] = Math.max(0, paper[0] - 36);
			ans++;
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
