import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자라는 참외의 수
		int n = Integer.parseInt(br.readLine());

		// 육각형 참외밭의 정보 입력
		List<int[]> d = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d.add(new int[] { a, b });
		}

		// 큰 직사각형의 가로, 세로 최대
		int maxW = 0;
		int maxH = 0;
		for (int i = 0; i < 6; i++) {
			int a = d.get(i)[0];
			int b = d.get(i)[1];

			// 가로일때
			if (a == 1 || a == 2) {
				if (b > maxW) {
					maxW = b;
				}
			}

			// 세로일때
			if (a == 3 || a == 4) {
				if (b > maxH) {
					maxH = b;
				}
			}
		}
		int bigSquare = maxW * maxH;

		// 큰 직사각형 코너 찾기
		int bigIdx = 0;
		int bigPair = 0;
		for (int i = 0; i < 6; i++) {
			int now = d.get(i)[1] * d.get((i + 1) % 6)[1];
			if (now > bigPair) {
				bigPair = now;
				bigIdx = i;
			}
		}

		// 작은 직사각형 넓이
		int smallSquare = d.get((bigIdx + 3) % 6)[1] * d.get((bigIdx + 4) % 6)[1];

		// 전체 참외 개수 구하기
		int ans = (bigSquare - smallSquare) * n;

		// 답 출력하기
		System.out.println(ans);

	}
}
