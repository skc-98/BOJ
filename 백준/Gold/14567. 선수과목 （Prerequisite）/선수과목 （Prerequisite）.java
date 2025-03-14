import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 과목의 수, 선수 조건의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 선수과목 상태 저장할 행렬
		int[][] prior = new int[n + 1][n + 1];

		// 선수과목 수를 저장할 배열
		int[] degree = new int[n + 1];

		// 선수과목 조건 m개 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			prior[b][a] = 1;
			degree[b]++;
		}

		// 몇 학기에 이수할 수 있는지 저장할 배열
		int[] ans = new int[n + 1];

		// 학기 수
		int count = 0;
		int semester = 0;

		// 원래 차수 복사해두기
		int[] newdegree = Arrays.copyOf(degree, degree.length);

		// 모든 과목의 이수 학기 정할때까지 진행
		while (true) {
			semester++;
			// 현재 남은 진입 차수 세고 0인거는 답에 현재 학기 저장
			for (int i = 1; i <= n; i++) {
				if (degree[i] == 0 && ans[i] == 0) {
					ans[i] = semester;
					count++;
					for (int j = 1; j <= n; j++) {
						// 연결도 끊고, 차수도 내리기
						if (prior[j][i] == 1) {
							prior[j][i] = 0;
							newdegree[j]--;
						}
					}
				}
			}

			// 한 학기 단위로 끝나고 나면 degree 갱신
			degree = Arrays.copyOf(newdegree, newdegree.length);

			// 모든 과목이 정해지면 종료
			if (count == n)
				break;
		}

		// 답 출력하기
		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
