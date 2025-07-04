import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집합의 크기
		int n = Integer.parseInt(br.readLine());

		// 정수 저장할 배열
		int[] d = new int[n];

		// 정수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 포함시킬 정수 입력
		int num = Integer.parseInt(br.readLine());

		// 찾는 수가 포함되어 있다면 좋은 구간의 수는 0
		for (int i = 0; i < n; i++) {
			if (d[i] == num) {
				System.out.println(0);
				return;
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 작은 값 중 최대값, 큰 값 중 최소값
		int left = 0;
		int right = 1000001;

		for (int i = 0; i < n; i++) {
			if (d[i] < num) {
				left = d[i];
			} else if (d[i] > num) {
				right = d[i];
				break;
			}
		}

		// 답 출력하기
		ans = (num - left) * (right - num) - 1;
		System.out.print(ans);
	}
}
