import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생의 수, 팀의 인원수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 스탯 배열
		int[][] stat = new int[n + 1][3];

		// 재원이 스탯 입력
		st = new StringTokenizer(br.readLine());
		stat[0][0] = Integer.parseInt(st.nextToken());
		stat[0][1] = Integer.parseInt(st.nextToken());
		stat[0][2] = Integer.parseInt(st.nextToken());

		// 학생들의 스탯 입력
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			stat[i][0] = Integer.parseInt(st.nextToken());
			stat[i][1] = Integer.parseInt(st.nextToken());
			stat[i][2] = Integer.parseInt(st.nextToken());
		}

		// 재원이 스탯 합
		long jaewon = (long) stat[0][0] + stat[0][1] + stat[0][2];

		// 후보 리스트
		List<int[]> li = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			long statSum = (long) stat[i][0] + stat[i][1] + stat[i][2];
			if (jaewon >= statSum) {
				li.add(new int[] { i, (int) statSum });
			}
		}

		// 정렬
		li.sort((a, b) -> b[1] - a[1]);

		// 선택 가능한 최대 학생 수
		int limit = Math.min(m - 1, li.size());

		// 출력 (재원이는 0번)
		StringBuilder sb = new StringBuilder();
		sb.append(0);

		for (int i = 0; i < limit; i++) {
			sb.append(" ").append(li.get(i)[0]);
		}

		System.out.println(sb.toString());
	}
}
