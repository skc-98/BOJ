import java.util.*;
import java.io.*;

public class Main {
	// 각 테트로미노 좌표화
	static int[][][] tetromino = {
			// ㅡ
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },

			// ㅁ
			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },

			// ㄴ
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } }, { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 1 }, { 1, 1 }, { 2, 1 }, { 2, 0 } }, { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 0 } },

			// ㄹ
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } },

			// ㅗ
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
			{ { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } } };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종이의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 종이 배열
		int[][] d = new int[n][m];

		// 종이에 쓰여진 수 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 답 변수
		int ans = 0;

		// 최대 합 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int[][] shape : tetromino) {
					int sum = 0;
					boolean valid = true;

					for (int[] block : shape) {
						int x = i + block[0];
						int y = j + block[1];

						if (x < 0 || x >= n || y < 0 || y >= m) {
							valid = false;
							break;
						}
						sum += d[x][y];
					}

					if (valid)
						ans = Math.max(ans, sum);
				}
			}
		}

		// 답 출력
		System.out.print(ans);
	}
}
