import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 대학의 수
		int n = Integer.parseInt(br.readLine());

		// 강연 배열
		int[][] d = new int[n][2];

		// 강연 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[i][0] = a;
			d[i][1] = b;
		}

		// 정렬
		Arrays.sort(d, (a, b) -> Integer.compare(b[0], a[0]));

		// 타임테이블
		boolean[] timetable = new boolean[10001];

		// 정답 변수
		int ans = 0;

		// 모든 강연 돌면서 가능한 강의 추가
		for (int i = 0; i < n; i++) {
			for (int j = d[i][1]; j >= 1; j--) {
				if (!timetable[j]) {
					timetable[j] = true;
					ans += d[i][0];
					break;
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
