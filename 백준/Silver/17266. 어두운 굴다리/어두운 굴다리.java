import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 굴다리 길이 입력
		int n = Integer.parseInt(br.readLine());

		// 가로등의 개수
		int m = Integer.parseInt(br.readLine());

		// 배열 생성
		int[] d = new int[m];

		// 가로등의 높이가 될 정답
		int ans = 0;

		// 가로등의 위치 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 입구부터 첫 번째 가로등 높이 구하기
		ans = Math.max(ans, d[0] - 0);

		// 각 가로등 사이 거리
		for (int i = 1; i < m; i++) {
			int gap = d[i] - d[i - 1];
			int height = (gap + 1) / 2;
			ans = Math.max(ans, height);
		}

		// 마지막부터 출구까지 거리
		ans = Math.max(ans, n - d[m - 1]);

		// 답 출력하기
		System.out.println(ans);
	}
}