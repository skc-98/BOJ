import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 직사각형의 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 직사각형 영역 저장할 배열
		int[][] d = new int[501][501];

		// 직사각형 좌표 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					d[j][k]++;
				}
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 직사각형 영역 세기
		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) {
				if (d[i][j] != 0)
					ans++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
