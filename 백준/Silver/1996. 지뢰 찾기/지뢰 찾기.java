import java.util.*;
import java.io.*;

public class Main {
	// 방향 벡터
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 지도 상태를 저장할 배열, 답 배열
		char[][] d = new char[n][n];
		char[][] ans = new char[n][n];

		// 지도의 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 지도 순회하면서 답 지도 생성
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 지뢰가 위치하는 곳은 변환
				if (d[i][j] >= '1' && d[i][j] <= '9') {
					ans[i][j] = '*';
				}
				// 숫자가 될 칸 주위의 지뢰 수 세기
				else {
					// 지뢰의 수
					int mine = 0;

					// 8방 탐색
					for (int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						// 범위 초과 검사
						if (x < 0 || x >= n || y < 0 || y >= n)
							continue;

						// 지뢰 수 더하기
						if (d[x][y] >= '1' && d[x][y] <= '9') {
							mine += d[x][y] - '0';
						}
					}

					// 만약 10개 이상이면 M으로 아니면 지뢰 숫자로 넣기
					if (mine >= 10) {
						ans[i][j] = 'M';
					} else {
						ans[i][j] = (char) (mine + '0');
					}
				}
			}
		}

		// 답 출력하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
}
