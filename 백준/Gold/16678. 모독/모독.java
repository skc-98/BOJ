import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 국회의원 수
		int n = Integer.parseInt(br.readLine());

		// 명예 점수 배열
		int[] d = new int[n];

		// 국회의원 명예 점수 입력
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 정렬
		Arrays.sort(d);

		// 답 변수
		long ans = 0;

		// 해커의 수 구하기
		int current = 1;
		for (int i = 0; i < n; i++) {
			if (d[i] >= current) {
				ans += d[i] - current;
				current++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
