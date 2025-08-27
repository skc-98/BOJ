import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생 수 입력
		int n = Integer.parseInt(br.readLine());

		// 반 정보 입력할 배열
		int[][] ban = new int[n][5];

		// 각 학생 친구관계 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				ban[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		// 각 학생의 친구 여부를 저장할 2차원 논리 배열
		boolean[][] friend = new boolean[n][n];

		// 학생 번호 기준으로
		for (int i = 0; i < n; i++) {
			// 각 학년 기준으로
			for (int j = 0; j < 5; j++) {
				// 나머지 친구들 기준으로
				for (int k = 0; k < n; k++) {
					if (i == k)
						continue;
					// 같은 반이었던 적이 있으면
					if (ban[i][j] == ban[k][j]) {
						// i번째 학생은 k번째 학생과 친구이다
						friend[i][k] = true;
					}
				}
			}
		}

		// 이제 다 정했으니 답 구하기
		int ans = 0;
		int maxFriend = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (friend[i][j])
					count++;
			}
			if (maxFriend < count) {
				maxFriend = count;
				ans = i;
			}
		}

		// 답 출력하기
		System.out.println(ans + 1);
	}
}
