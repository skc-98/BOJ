import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 입력
		int n = Integer.parseInt(br.readLine());

		// 루머 여부 확인 배열
		int[] rumor = new int[n + 1];
		Arrays.fill(rumor, -1);

		// 인접 리스트 생성
		List<List<Integer>> li = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 주변인 관계 입력
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (true) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					break;
				li.get(i).add(num);
			}
		}

		// BFS용 큐 생성
		Queue<int[]> q = new ArrayDeque<>();

		// 루머 유포자 입력
		int startPeople = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < startPeople; i++) {
			int startMember = Integer.parseInt(st.nextToken());
			rumor[startMember] = 0;

			// 최초 유포자 큐에 넣기
			q.add(new int[] { startMember, rumor[startMember] });
		}

		// 카운트 배열 생성
		int[] count = new int[n + 1];

		// BFS 시작
		while (!q.isEmpty()) {
			int now = q.peek()[0];
			int days = q.peek()[1];
			q.poll();

			// 주변인 돌기
			for (int k = 0; k < li.get(now).size(); k++) {
				int next = li.get(now).get(k);

				// 이미 믿으면 건너뛰고
				if (rumor[next] != -1)
					continue;

				// 카운트 증가
				count[next]++;

				// 과반수라면 큐에 추가하기
				if (rumor[next] == -1 && count[next] * 2 >= li.get(next).size()) {
					rumor[next] = rumor[now] + 1;
					q.add(new int[] { next, rumor[next] });
				}
			}
		}

		// 루머 결과 출력
		for (int i = 1; i <= n; i++) {
			System.out.print(rumor[i] + " ");
		}
	}
}