import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버튼의 수
		int n = Integer.parseInt(br.readLine());

		// 버튼 배열, 버튼 상태 배열
		int[] button = new int[n];
		int[] d = new int[n];

		// 버튼 최종 상태 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 답 찾기
		int ans = 0;
		// 버튼 누르기
		for (int i = 0; i < n; i++) {
			if (button[i] != d[i]) {
				ans++;
				// 자기 자신
				if (button[i] == 1)
					button[i] = 0;
				else
					button[i] = 1;
				// 다음 칸
				if (i + 1 < n) {
					if (button[i + 1] == 1)
						button[i + 1] = 0;
					else
						button[i + 1] = 1;
				}
				// 다다음 칸
				if (i + 2 < n) {
					if (button[i + 2] == 1)
						button[i + 2] = 0;
					else
						button[i + 2] = 1;
				}
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
