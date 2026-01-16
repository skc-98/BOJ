import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드의 수
		int n = Integer.parseInt(br.readLine());

		// 카드 입력
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 현재 제자리에 있는 카드 구하기
		int now = 1;
		for (int i = 0; i < n; i++) {
			if (d[i] == now) {
				now++;
			}
		}

		// 답 출력하기
		System.out.println(n - now + 1);
	}
}
