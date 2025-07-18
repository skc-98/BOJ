import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 친구 상태 저장 배열
		char[][] d = new char[n][n];

		// 친구 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 2-친구 카운트할 배열
		int[] friend = new int[n];

		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;

				// 직접 친구
				if (d[i][j] == 'Y') {
					visited[j] = true;
				}
				// 친구의 친구
				else {
					for (int k = 0; k < n; k++) {
						if (d[i][k] == 'Y' && d[k][j] == 'Y') {
							visited[j] = true;
							break;
						}
					}
				}
			}

			// 방문한 사람 수 카운트
			for (boolean v : visited) {
				if (v)
					friend[i]++;
			}
		}

		// 답 찾고 출력
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, friend[i]);
		}
		System.out.print(ans);
	}
}
