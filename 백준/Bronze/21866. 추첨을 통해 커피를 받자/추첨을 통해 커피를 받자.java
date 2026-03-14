import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문제별 최대 점수 배열
		int[] maxScore = { 100, 100, 200, 200, 300, 300, 400, 400, 500 };

		// 9 문제 점수 합 구하기
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 9; i++) {
			int score = Integer.parseInt(st.nextToken());
			sum += score;

			// 문제당 최대 점수 초과시
			if (score > maxScore[i]) {
				System.out.println("hacker");
				return;
			}
		}

		// 답에 맞게 출력
		if (sum < 100) {
			System.out.println("none");
		} else {
			System.out.println("draw");
		}

	}
}
