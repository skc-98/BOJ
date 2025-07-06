import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 선을 그은 횟수
		int n = Integer.parseInt(br.readLine());

		// 선 저장할 리스트
		List<int[]> line = new ArrayList<>();

		// 두 점의 위치 n개 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			line.add(new int[] { x, y });
		}

		// x기준으로 리스트 정렬
		line.sort((x, y) -> {
			if (x[0] != y[0])
				return Integer.compare(x[0], y[0]);
			return Integer.compare(x[1], y[1]);
		});

		// 답 저장할 변수
		int ans = 0;

		// 시작점 좌표값
		int start = line.get(0)[0];
		int end = line.get(0)[1];

		// 값 구하기
		for (int i = 1; i < n; i++) {
			int x = line.get(i)[0];
			int y = line.get(i)[1];

			if (x > end) {
				ans += end - start;
				start = x;
				end = y;
			} else {
				end = Math.max(end, y);
			}
		}

		// 마지막 값 더해주기
		ans += end - start;
		System.out.println(ans);
	}
}
