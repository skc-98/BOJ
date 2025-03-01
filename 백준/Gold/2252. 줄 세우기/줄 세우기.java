import java.util.*;
import java.io.*;

// 아이디어
// 학생간의 선후 관계가 확실하기 때문에 위상 정렬을 통해 해결했습니다.
// 시간제한: 2초, 메모리제한: 128MB
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생의 수 n, 키 비교 수 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 키 비교 넣을 리스트
		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 진입 차수를 저장할 배열
		int[] degree = new int[n + 1];

		// 키 비교 입력
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);

			// 줄 뒤에 오는 친구의 진입 차수 증가
			degree[b]++;
		}

		// 진입차수가 0인 친구 큐에넣기
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		// 진입 차수가 0인 학생과 연결된 학생의 진입 차수 감소 시켜주고 다시 0이된 친구는 넣는 방식으로 위상 정렬 진행
		while (!q.isEmpty()) {
			// 큐에서 빼고
			int now = q.poll();

			// 빼면 바로 출력
			System.out.print(now + " ");

			// 진입차수 감소, 리스트 값 수정
			for (int iter : graph[now]) {
				// 연결된 학생의 진입 차수 감소
				degree[iter]--;

				// 진입 차수가 0이 된 학생 큐에 삽입
				if (degree[iter] == 0) {
					q.add(iter);
				}
			}
		}
	}
}
