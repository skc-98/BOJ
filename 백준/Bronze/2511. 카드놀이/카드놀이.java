import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드 정보 저장할 배열
		int[] a = new int[10];
		int[] b = new int[10];

		// A 카드 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		// B 카드 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		int scoreA = 0;
		int scoreB = 0;
		char ans = 'D';
		for (int i = 0; i < 10; i++) {
			if (a[i] > b[i]) {
				scoreA += 3;
				ans = 'A';
			} else if (a[i] < b[i]) {
				scoreB += 3;
				ans = 'B';
			} else {
				scoreA += 1;
				scoreB += 1;
			}
		}

		System.out.println(scoreA + " " + scoreB);
		if (scoreA > scoreB) {
			System.out.println("A");
		} else if (scoreA < scoreB) {
			System.out.println("B");
		} else {
			System.out.println(ans);
		}
	}
}
