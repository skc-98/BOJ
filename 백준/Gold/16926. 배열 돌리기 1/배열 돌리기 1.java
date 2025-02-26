import java.util.*;
import java.io.*;

// 아이디어
// r번 주어진 배열을 반시계 방향으로 회전 시키는 구현 문제입니다.
// 배열을 회전하는 구역을 나눠서 회전시키는 방식으로 구현했습니다.
// 시간제한: 1초, 메모리 제한: 512MB
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열의 크기: n,m
		// 수행해야하는 회전의 수: r
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		// 배열의 정보 입력
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 층별로 회전을 진행합니다.
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < Math.min(n, m) / 2; j++) {
				// 각 층별 좌표
				int top = j, bottom = n - j - 1, left = j, right = m - j - 1;

				// 첫 번째 값을 저장해두고 이동 시작
				int temp = d[top][left];

				// 4방향 회전
				for (int k = left; k < right; k++) {
					d[top][k] = d[top][k + 1];
				}
				for (int k = top; k < bottom; k++) {
					d[k][right] = d[k + 1][right];
				}
				for (int k = right; k > left; k--) {
					d[bottom][k] = d[bottom][k - 1];
				}
				for (int k = bottom; k > top + 1; k--) {
					d[k][left] = d[k - 1][left];
				}

				// 첫 번째 값 넣어주기
				d[top + 1][left] = temp;
			}
		}

		// 최종적인 배열의 상태 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
}
