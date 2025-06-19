import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 아파트 층 수, 참가자의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 현재 손 상태를 저장할 리스트
		List<int[]> hands = new ArrayList<>();

		// 각 참가자의 손 높이 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			hands.add(new int[] { a, i + 1 });
			hands.add(new int[] { b, i + 1 });
		}

		// 손 높이 기준으로 정렬
		hands.sort(Comparator.comparingInt(o -> o[0]));

		// n번째 손 주인 출력
		int total = hands.size();
		int idx = (n - 1) % total;
		System.out.println(hands.get(idx)[1]);
	}
}
