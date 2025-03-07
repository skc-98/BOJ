import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 상근이가 가진 카드의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 상근이가 가진 카드 입력
		Map<Integer, Integer> mp = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int cardNum = Integer.parseInt(st.nextToken());
			mp.put(cardNum, mp.getOrDefault(cardNum, 0) + 1);
		}

		// 확인해야할 카드 수 입력
		int m = Integer.parseInt(br.readLine());

		// 출력 성능 개선을 위한 StirngBuilder 사용
		StringBuilder sb = new StringBuilder();

		// 확인할 카드 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int findNum = Integer.parseInt(st.nextToken());
			sb.append(mp.getOrDefault(findNum, 0)).append(" ");
		}
		System.out.println(sb);
	}
}