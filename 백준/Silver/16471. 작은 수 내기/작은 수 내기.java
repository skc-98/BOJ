import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드 수
		int n = Integer.parseInt(br.readLine());

		// 주언이랑 사장님 카드 입력
		Integer[] d1 = new Integer[n];
		Integer[] d2 = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d2[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d1);
		Arrays.sort(d2);

		// 투 포인터로 주언이가 얻을 수 있는 최대 점수 계산
		int idx1 = 0;
		int idx2 = 0;
		int win = 0;

		while (idx1 < n && idx2 < n) {
			if (d1[idx1] < d2[idx2]) {
				win++;
				idx1++;
				idx2++;
			} else {
				idx2++;
			}
		}

		// 절반 이상이면 이길 확률 존재
		int possible = (n + 1) / 2;
		if (win >= possible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
