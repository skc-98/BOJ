import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 여행 계획에 속한 도시의 수 m입력
		int m = Integer.parseInt(br.readLine());

		// 도시의 인접 행렬
		int[][] d = new int[n][n];

		// n개의 도시 연결 관계 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 자기 자신은 항상 연결 처리
		for (int i = 0; i < n; i++) {
			d[i][i] = 1;
		}

		// 플로이드-워셜을 통한 연결 관계 갱신
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
					}
				}
			}
		}

		// 연결 관계 저장할 배열
		int[] link = new int[m];

		// 연결 관계 입력
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 연결 관계 배열에 저장
		for (int i = 0; i < m; i++) {
			link[i] = Integer.parseInt(st.nextToken());
		}

		// 연결 관계 확인하면서 정답 여부 출력
		for (int i = 0; i < m - 1; i++) {
			if (d[link[i] - 1][link[i + 1] - 1] != 1) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
}
