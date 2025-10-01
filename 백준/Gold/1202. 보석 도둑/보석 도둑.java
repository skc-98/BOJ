import java.util.*;
import java.io.*;

// 이전 가방에서 아직 담지 않은 보석은 이후 가방에서도 담을 수 있다는게 핵심 아이디어
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보석과 가방의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 보석 배열
		int[][] dia = new int[n][2];

		// 각 보석의 정보 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dia[i][0] = Integer.parseInt(st.nextToken());
			dia[i][1] = Integer.parseInt(st.nextToken());
		}

		// 가방 배열
		int[] bag = new int[m];

		// 가방 입력
		for (int i = 0; i < m; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		// 보석 무게 순으로 정렬
		Arrays.sort(dia, (a, b) -> Integer.compare(a[0], b[0]));

		// 가방 무게 순으로 정렬
		Arrays.sort(bag);

		// 답 변수
		long ans = 0;

		// 가방에 들어갈 후보 보석 넣을 우선순위 큐, 무게만 넣을거임
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// 모든 가방을 돌면서 뭘 넣을지 확인
		int idx = 0;
		for (int i = 0; i < m; i++) {
			while (idx < n && dia[idx][0] <= bag[i]) {
				pq.add(dia[idx][1]);
				idx++;
			}

			// 넣을 수 있는거 답에 추가하고 사용 처리
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
