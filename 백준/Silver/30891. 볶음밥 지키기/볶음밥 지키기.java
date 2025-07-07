import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 밥알의 개수와 웍 반지름 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 밥알의 좌표를 저장할 배열
		int[][] rice = new int[n][2];

		// 밥알의 좌표 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			rice[i][0] = Integer.parseInt(st.nextToken());
			rice[i][1] = Integer.parseInt(st.nextToken());
		}

		// 가장 많은 밥알을 지킬 수 있는 좌표 탐색
		int max = 0;
		int x = 0, y = 0;
		int m2 = m * m;

		for (int i = -200; i <= 200; i++) {
			for (int j = -200; j <= 200; j++) {
				// 현재 웍 위치에서 지킬 수 있는 밥알 수
				int count = 0;

				// 각 밥알에 대해 거리 계산
				for (int k = 0; k < n; k++) {
					int dx = i - rice[k][0];
					int dy = j - rice[k][1];
					// 유클리드 거리 제곱이 반지름보다 작으면 포함
					if (dx * dx + dy * dy <= m2)
						count++;
				}

				// 최대값 갱신
				if (count > max) {
					max = count;
					x = i;
					y = j;
				}
			}
		}

		// 답 출력하기
		System.out.println(x + " " + y);
	}
}
