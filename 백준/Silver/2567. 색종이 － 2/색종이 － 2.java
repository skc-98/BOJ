import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 영역 배열
		int[][] d = new int[101][101];

		// 색종이의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 색종이 정보 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 색종이 시작점부터 색종이 채우기
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					d[j][k]++;
				}
			}
		}

		// 둘레 재기
		int ans = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (d[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101 || d[nx][ny] == 0)
							ans++;
					}
				}
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
