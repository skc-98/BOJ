import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 맵 입력
		int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1) {
					if (x1 == -1) {
						x1 = i;
						y1 = j;
					} else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}

		// 좌표 거리 차이 구하기
		int ans = Math.abs(x2 - x1) + Math.abs(y2 - y1);

		// 답 출력하기
		System.out.print(ans);
	}
}
