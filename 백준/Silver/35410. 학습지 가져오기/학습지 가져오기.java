import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생의 수
		int n = Integer.parseInt(br.readLine());

		// 시간 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 답 구하기
		int now = 0;
		for (int i = 0; i < n; i++) {
			if (now < d[i]) {
				now = d[i] + 1;
			} else {
				now++;
			}
		}

		// 답 출력하기
		System.out.println(now);
	}
}
