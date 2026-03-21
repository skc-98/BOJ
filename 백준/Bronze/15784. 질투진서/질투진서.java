import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기, 진서 위치 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;

		// 강의실 입력
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 진서의 값
		int jin = d[x][y];

		// 잘생긴 친구 있나 확인
		boolean handsome = false;
		for (int i = 0; i < n; i++) {
			if (d[x][i] > jin) {
				handsome = true;
			}
			if (d[i][y] > jin) {
				handsome = true;
			}
		}

		// 답 출력하기
		if (handsome) {
			System.out.print("ANGRY");
		} else {
			System.out.println("HAPPY");
		}
	}
}
