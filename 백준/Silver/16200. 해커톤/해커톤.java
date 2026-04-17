import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생 수
		int n = Integer.parseInt(br.readLine());

		// 학생 정보 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(d);

		// 답 구하기
		int ans = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max == 0) {
				max = d[i] - 1;
				ans++;
				continue;
			}
			max--;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
