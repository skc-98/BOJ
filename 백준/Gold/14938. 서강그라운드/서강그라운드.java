import java.util.*;
import java.io.*;

// 플로이드를 거리에 대해 진행하면 되는 문제
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지역의 수, 수색범위, 길의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());
		int road = Integer.parseInt(st.nextToken());

		// 거리 배열, 아이템 배열
		int[][] d = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(d[i], 10000000);
			d[i][i] = 0;
		}
		int[] item = new int[n + 1];

		// 각 도시의 아이템 수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		// 연결된 길의 정보 입력
		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			d[start][end] = value;
			d[end][start] = value;
		}

		// 거리 배열 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}

		// 답 변수
		int ans = 0;

		// 1번부터 n번 도시까지 어떤 경우에 가장 많은 아이템을 얻는지 확인
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (d[i][j] <= range) {
					sum += item[j];
				}
			}
			ans = Math.max(ans, sum);
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
