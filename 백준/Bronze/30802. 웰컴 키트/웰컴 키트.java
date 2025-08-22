import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 참가자의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 티셔츠 저장해 둘 배열
		int[] tshirt = new int[6];

		// 6가지 사이즈별 신청자 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			tshirt[i] = Integer.parseInt(st.nextToken());
		}

		// 티셔츠와 펜의 묶음 수 입력
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		// 티셔츠 묶음 수 구하기
		int tSum = 0;
		for (int i = 0; i < 6; i++) {
			tSum += (tshirt[i] / t);
			tshirt[i] %= t;
			if (tshirt[i] != 0)
				tSum++;
		}

		// 답 출력부
		System.out.println(tSum);
		System.out.println(n / p + " " + n % p);
	}
}
