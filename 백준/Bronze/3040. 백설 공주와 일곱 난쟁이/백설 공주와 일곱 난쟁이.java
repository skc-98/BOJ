import java.util.*;
import java.io.*;

// 아이디어
// 아홉 난쟁이 중 일곱명을 뽑아서 그 합이 100이 되는 경우가 답이됩니다.
// 따라서 아홉 난쟁이 중 일곱명을 뽑는 모든 조합을 계산하면 답을 구할 수 있습니다.
// 시간 제한: 1초, 메모리 제한: 128MB
public class Main {
	// 전역변수 선언
	static int[] d = new int[9];
	static int[] comb = new int[7];

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 아홉 난쟁이의 정보 입력
		for (int i = 0; i < 9; i++) {
			d[i] = Integer.parseInt(br.readLine());
		}

		// 조합 시작
		function(0, 0);
	}

	static void function(int cnt, int start) {
		// 일곱개 선택하면
		if (cnt == 7) {
			int sum = 0;
			// 일곱명 합 구하고
			for (int i = 0; i < 7; i++) {
				sum += comb[i];
			}
			if (sum == 100) {
				// 출력하기
				for (int i = 0; i < 7; i++) {
					System.out.println(comb[i]);
				}
				// 답을 찾았으니 프로그램 종료 해버리기
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			// 선택하면 comb 배열에 난쟁이 무게 저장
			comb[cnt] = d[i];
			function(cnt + 1, i + 1);
		}
	}
}
