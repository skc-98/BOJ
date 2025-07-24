import java.util.*;
import java.io.*;

// 충전에 필요한 시간은 short 범위까지만
public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 전자기기의 수, 콘센트의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 각 전자기기 충전 소요시간 저장할 배열
		Integer[] d = new Integer[n];

		// n 개의 충전에 필요한 시간 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 내림차순 정렬
		Arrays.sort(d, Collections.reverseOrder());

		// 충전 소요시간 저장 배열 추가
		int[] charger = new int[m];

		// 각 기기를 하나씩 추가해주면 됨
		for (int k = 0; k < n; k++) {
			// 사용할 충전기 고르는 로직
			int minidx = 0;
			int minvalue = Integer.MAX_VALUE;
			for (int i = 0; i < m; i++) {
				if (minvalue > charger[i]) {
					minidx = i;
					minvalue = charger[i];
				}
			}

			// 가장 낮은 충전기에 추가
			charger[minidx] += d[k];
		}

		// 답을 저장할 변수
		int ans = 0;

		// 배열에서 가장 큰 값 찾기
		for (int i = 0; i < m; i++) {
			if (ans < charger[i])
				ans = charger[i];
		}

		// 답 출력
		System.out.println(ans);
	}
}
