import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 부서의 수, 각 부서 입력
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			li.add(new ArrayList<>());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			for (int j = 0; j < people; j++) {
				li.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		// 각 부서 면담시간 합으로 정렬
		Collections.sort(li, (a, b) -> {
			int sumA = 0;
			for (int x : a)
				sumA += x;
			int sumB = 0;
			for (int x : b)
				sumB += x;
			return sumA - sumB;
		});

		// 각 부서 합 시간 누적해서 더하기
		int ans = 0;
		int total = 0;
		for (int i = 0; i < li.size(); i++) {
			int sum = 0;
			for (int j = 0; j < li.get(i).size(); j++) {
				sum += li.get(i).get(j);
			}
			total += sum;
			ans += total;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
