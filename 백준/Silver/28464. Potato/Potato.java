import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 접시의 수
		int n = Integer.parseInt(br.readLine());

		// 접시의 감자튀김 수
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 답 구하기
		int a = 0, b = 0;
		int right = 0, left = n - 1;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				a += d[left];
				left--;
			} else {
				b += d[right];
				right++;
			}
		}

		// 답 출력하기
		System.out.print(b + " " + a);
	}
}
