import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 얼음 양동이의 수, 닿을 수 있는 거리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 양동이 배열
		int[] d = new int[1_000_001];
		int maxX = 0;

		// 각 양동이의 얼음의 양 좌표
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			d[x] = g;
			maxX = Math.max(maxX, x);
		}

		// 슬라이딩 윈도우를 이용한 합 계산
		int priSum = 0; // 현재 창의 합
		int ans = 0; // 최대값 저장
		int k2 = 2 * k + 1; // 창의 길이 (2k + 1)

		for (int i = 0; i <= 1_000_000; i++) {
			// i가 창의 범위를 넘어가면 왼쪽 값 제거
			if (i >= k2) {
				priSum -= d[i - k2];
			}

			// 현재 위치의 얼음 더하기
			priSum += d[i];

			// 최대값 갱신
			if (priSum > ans) {
				ans = priSum;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
