import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 리스트
		List<Long> list = new ArrayList<>();

		// DFS로 감소하는 수 생성
		for (int i = 0; i < 10; i++) {
			dfs(i, 1, list);
		}

		// 정렬
		Collections.sort(list);

		// n이 범위 초과면 -1
		if (n >= list.size()) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(n));
		}
	}

	// 감소하는 수 생성하는 메서드
	static void dfs(long num, int len, List<Long> list) {
		// 현재 수 저장
		list.add(num);

		// 최대 자리수 10 도달하면 종료
		if (len == 10)
			return;

		// 다음 자리수는 현재 마지막 자리보다 작은 수만 가능
		for (int i = 0; i < num % 10; i++) {
			dfs(num * 10 + i, len + 1, list);
		}
	}
}
