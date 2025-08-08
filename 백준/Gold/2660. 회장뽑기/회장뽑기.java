import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 회원의 수
		int n = Integer.parseInt(br.readLine());

		// 인접 행렬 생성
		int[][] d = new int[n + 1][n + 1];

		// 행렬 초기화
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], 999999);
		}

		// 친구 관계 입력
		while (true) {
			// 끝날때까지 계속 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			d[a][b] = 1;
			d[b][a] = 1;
		}

		// 플로이드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) {
						d[i][j] = 0;
						continue;
					}
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}

		// 친구 관계 수 가장 작은 값 구하기
		int ansRel = 99999;
		int ansCount = 0;
		int[] relation = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int maxRel = 0;
			for (int j = 1; j <= n; j++) {
				maxRel = Math.max(maxRel, d[i][j]);
			}
			relation[i] = maxRel;
			ansRel = Math.min(maxRel, ansRel);
		}

		// 회장 후보 수 카운트, 후보 추가
		for (int i = 1; i <= n; i++) {
			if (relation[i] == ansRel)
				ansCount++;
		}

		// 답 출력하기
		System.out.print(ansRel + " " + ansCount);
		System.out.println();
		for (int i = 1; i <= n; i++) {
			if (relation[i] == ansRel)
				System.out.print(i + " ");
		}
	}
}
