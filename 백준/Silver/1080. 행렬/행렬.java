import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 행렬의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 행렬 A,B 생성
		int[][] d1 = new int[n][m];
		int[][] d2 = new int[n][m];

		// 행렬 A 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d1[i][j] = s.charAt(j) - '0';
			}
		}

		// 행렬 B 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				d2[i][j] = s.charAt(j) - '0';
			}
		}

		// 답 변수
		int ans = 0;

		// 가장 좌측 위부터 다르면 뒤집기
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (d1[i][j] != d2[i][j]) {
					ans++;
					for (int x = i; x <= i + 2; x++) {
						for (int y = j; y <= j + 2; y++) {
							if (d1[x][y] == 1)
								d1[x][y] = 0;
							else
								d1[x][y] = 1;
						}
					}
				}
			}
		}

		// 여기서 다르면 -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d1[i][j] != d2[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}

		// 아니면 답 출력
		System.out.print(ans);
	}
}
