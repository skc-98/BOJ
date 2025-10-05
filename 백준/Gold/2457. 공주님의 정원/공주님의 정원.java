import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 꽃의 총 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 각 꽃의 정보 저장할 배열
		int[][] flower = new int[n][2];

		// 각 꽃의 피는 날과 지는 날 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());

			// 월 일을 숫자로 바꿔서 저장
			int start = startM * 100 + startD;
			int end = endM * 100 + endD;
			flower[i][0] = start;
			flower[i][1] = end;
		}

		// 꽃들을 시작 기준 오름차순, 같으면 종료 일자 기준 내림차순
		Arrays.sort(flower, (a, b) -> {
			if (a[0] == b[0])
				return b[1] - a[1];
			return a[0] - b[0];
		});

		// 3월 1일부터 11월 30일까지 덮어야 함
		int targetStart = 301;
		int targetEnd = 1201;

		int idx = 0;
		int count = 0;
		int maxEnd = 0;
		int current = targetStart;

		// 다 덮을때까지 반복
		while (current < targetEnd) {
			boolean found = false;
			int tempMax = maxEnd;

			// 현재 날짜 전 또는 같은 날에 피는 꽃 중 가장 늦게 지는 꽃 찾기
			while (idx < n && flower[idx][0] <= current) {
				if (flower[idx][1] > tempMax) {
					tempMax = flower[idx][1];
					found = true;
				}
				idx++;
			}

			// 덮을 수 있는 꽃이 없는 경우는 0 출력하고 종료
			if (!found) {
				System.out.println(0);
				return;
			}

			// 꽃 선택
			count++;
			current = tempMax;
			maxEnd = tempMax;
		}

		// 성공시 답 출력
		System.out.print(count);
	}
}
