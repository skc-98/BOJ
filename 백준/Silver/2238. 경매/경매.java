import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 금액의 상한과 경매 참여 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 상한까지 배열, 각 가격에 해당하는 맵 관리
		int[] d = new int[n + 1];
		Map<Integer, List<String>> map = new HashMap<>();

		// 경매 참여 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int price = Integer.parseInt(st.nextToken());

			// 각 가격별 인원 수 증가
			d[price]++;

			// 이름 기록
			if (!map.containsKey(price)) {
				map.put(price, new ArrayList<>());
			}
			map.get(price).add(name);
		}

		// 최소 인원 수 찾기
		int minCount = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			if (d[i] > 0) {
				minCount = Math.min(minCount, d[i]);
			}
		}

		// 조건에 맞는 가장 낮은 가격 탐색
		int selectedPrice = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] == minCount) {
				selectedPrice = i;
				break;
			}
		}

		// 낙찰자: 해당 가격 제시자 중 가장 먼저 제시한 사람
		String winner = map.get(selectedPrice).get(0);

		// 결과 출력
		System.out.println(winner + " " + selectedPrice);
	}
}
