import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 마을의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 마을 위치, 사람 수 배열
		int[][] d = new int[n][2];

		// 사람 수의 총 합
		long peopleSum = 0;

		// 마을 위치, 사람 수 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d[i][0] = Integer.parseInt(st.nextToken());
			d[i][1] = Integer.parseInt(st.nextToken());
			peopleSum += d[i][1];
		}

		// 배열 정렬
		Arrays.sort(d, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		// 답 변수
		long ans = 0;

		// 누적할 사람 수
		long s = 0;

		// 각 마을 중 올바른 위치 찾기
		for (int i = 0; i < n; i++) {
			s += d[i][1];
			if (s * 2 >= peopleSum) {
				ans = d[i][0];
				break;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
