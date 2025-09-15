import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도미노의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 도미노 배열
		int[][] d = new int[n][2];

		// 도미노 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int point = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			d[i][0] = point;
			d[i][1] = high;
		}

		// 시작점 기준으로 정렬
		Arrays.sort(d, (a, b) -> Integer.compare(a[0], b[0]));

		// 답 변수
		int ans = 0;

		// 시작점 별로 다 돌면서 답 구하기
		int now = 0;
		for (int i = 0; i < n; i++) {
			if (d[i][0] > now) {
				ans++;
				now = d[i][0] + d[i][1];
			} else {
				now = d[i][0] + d[i][1];
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
