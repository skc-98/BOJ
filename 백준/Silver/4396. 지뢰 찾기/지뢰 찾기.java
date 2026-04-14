import java.util.*;
import java.io.*;

public class Main {
	// 8방 벡터
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵의 크기
		int n = Integer.parseInt(br.readLine());

		// 지뢰 위치 입력
		char[][] d = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 열림 여부 입력
		boolean[][] open = new boolean[n][n];
		boolean boom = false;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == 'x') {
					open[i][j] = true;

					// 지뢰가 열린 경우
					if (d[i][j] == '*') {
						boom = true;
					}
				}
			}
		}

		// 모든 점 돌면서 답 출력하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 지뢰가 열린 경우
				if (boom && d[i][j] == '*') {
					System.out.print('*');
				}
				// 안열렸을 경우
				else if (!open[i][j]) {
					System.out.print('.');
				}
				// 열린 경우
				else {
					int count = 0;
					for (int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];

						// 범위검사
						if (x < 0 || x >= n || y < 0 || y >= n)
							continue;

						if (d[x][y] == '*') {
							count++;
						}
					}
					System.out.print(count);
				}
			}
			System.out.println();
		}
	}
}
