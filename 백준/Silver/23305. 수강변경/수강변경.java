import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 신청한 수업 배열, 수강하고 싶은 수업 번호
		int[] d = new int[n];
		int[] t = new int[n];

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		// 번호별 개수 세기
		int[] count1 = new int[1000001];
		int[] count2 = new int[1000001];

		for (int i = 0; i < n; i++) {
			count1[d[i]]++;
		}
		for (int i = 0; i < n; i++) {
			count2[t[i]]++;
		}

		// 최대 만족 인원
		long satisfied = 0;
		for (int x = 1; x <= 1_000_000; x++) {
			if (count1[x] < count2[x])
				satisfied += count1[x];
			else
				satisfied += count2[x];
		}

		// 답 출력
		System.out.println((long) n - satisfied);
	}
}
