import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 수열 저장할 리스트
		List<Integer> list = new ArrayList<>();

		// 수열 계속 추가
		while (true) {
			// 이미 나온 수면 반복 시작
			if (list.contains(n)) {
				// 처음 나온 인덱스 = 반복 시작 전까지의 개수
				System.out.println(list.indexOf(n));
				break;
			}

			list.add(n);

			// 다음 수 계산
			int next = 0;
			int temp = n;
			while (temp > 0) {
				int digit = temp % 10;
				next += Math.pow(digit, m);
				temp /= 10;
			}
			n = next;
		}
	}
}
