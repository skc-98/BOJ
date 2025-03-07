import java.util.*;
import java.io.*;

// 아이디어
// 방향 비순환 그래프의 작업 순서를 결정하는 문제이기 때문에 위상 정렬을 통해서 해결할 수 있습니다.
public class Solution {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수는 10개로 고정
		for (int tc = 1; tc <= 10; tc++) {
			// 그래프 정점과 간선의 개수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			// 그래프 간 연결 관계를 가지는 행렬 생성
			int[][] d = new int[v + 1][v + 1];

			// 각 정점의 진입 차수를 저장할 배열
			int[] degree = new int[v + 1];

			// 그래프의 간선 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				d[start][end] = 1;
				degree[end]++;
			}

			// 해당 작업을 완료 했는지 확인할 배열
			boolean[] finish = new boolean[v + 1];

			// 먼저 작업 차수가 0인 작업을 큐에 넣기
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= v; i++) {
				if (degree[i] == 0) {
					q.add(i);
					// 큐에 넣으면 작업 완료 처리
					finish[i] = true;
				}
			}

			// 출력 처리
			System.out.printf("#%d ", tc);

			// 모든 작업을 처리 할때까지
			while (!q.isEmpty()) {
				// 큐에서 빼면서
				int now = q.poll();

				// 출력도 바로 하기
				System.out.print(now + " ");

				// 해당 작업과 연결된 간선 다 끊어주기
				for (int i = 1; i <= v; i++) {
					if (d[now][i] != 0) {
						d[now][i]--;
						// 끊은 간선만큼 진입 차수도 갱신
						degree[i]--;
					}
				}

				// 다시 작업 차수가 0인 작업 큐에 넣기
				for (int i = 1; i <= v; i++) {
					if (degree[i] == 0 && !finish[i]) {
						q.add(i);
						finish[i] = true;
					}
				}
			}

			// 테스트 케이스 끝나면 줄바꿈
			System.out.println();
		}
	}
}
