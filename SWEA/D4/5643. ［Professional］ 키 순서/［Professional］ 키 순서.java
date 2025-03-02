import java.util.*;
import java.io.*;

// 아이디어
// 플로이드 워셜을 통해 학생 간 키 비교 결과를 갱신하여
// 자신의 순위를 정확히 알 수 있는지 판단하는 방식으로 해결했습니다.
// 시간제한: 15개 테스트케이스를 합쳐 10초, 메모리제한: 256MB
public class Solution {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// n과 m입력
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			// 키를 비교한 결과 m개를 행렬에 입력
			boolean[][] d = new boolean[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				d[a][b] = true;
			}

			// 플로이드-워셜을 통해 키 비교 결과를 갱신
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					for (int k = 1; k <= n; k++) {
						// 학생 i가 k보다 작고 k가 j보다 작으면 i가 j보다 작은거니까 행렬 갱신
						if (d[i][k] && d[k][j]) {
							d[i][j] = true;
						}
					}
				}
			}

			// 답을 저장할 변수
			int ans = 0;

			// 각 학생별로 순위가 정확한지 판단
			for (int i = 1; i <= n; i++) {
				// i번째 학생에 대해 키 비교 가능한지 카운트할 변수
				int count = 0;
				for (int j = 1; j <= n; j++) {
					// 자기 자신은 제외
					if (i == j)
						continue;
					// i가 j보다 작거나 j가 i보다 작으면 i와 j는 비교 가능한거니까 카운트
					if (d[i][j] || d[j][i])
						count++;
				}
				// 자기 자신을 제외한 모든 학생과의 키 비교 결과를 알 수 있으면 카운트
				if (count == n - 1)
					ans++;
			}
			// 답 출력하기
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
