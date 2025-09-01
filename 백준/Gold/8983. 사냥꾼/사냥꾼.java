import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사대, 동물의 수, 사정거리 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());

		// 사대의 위치 배열
		int[] d = new int[m];

		// 사대의 위치 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 사대 정렬
		Arrays.sort(d);

		// 답 변수
		int ans = 0;

		// 동물 위치 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 각 동물 x좌표 기준으로 이분탐색, 좌우 사대 찾기
			int idx = Arrays.binarySearch(d, x);
			if (idx < 0)
				idx = -(idx + 1);

			// 찾은 좌우 사대에서 동물까지 맨해튼 거리 계산 후 카운트
			boolean check = false;
			if (idx < m && Math.abs(d[idx] - x) + y <= range) {
				check = true;
			}
			if (idx > 0 && Math.abs(d[idx - 1] - x) + y <= range) {
				check = true;
			}

			if (check)
				ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
