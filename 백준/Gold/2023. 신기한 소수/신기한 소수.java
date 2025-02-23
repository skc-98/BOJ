import java.util.*;
import java.io.*;

// 난이도: 9/10, 소수 판별 여부를 효율적으로 처리하기 힘들었음
// 또한 메모리 초과에 한번 걸림, 중복 순열을 구한 뒤 처리한게 아니라 구하면서 처리하도록 수정했음
// 아이디어
// n이 최대 8이기 때문에 n자리의 모든 중복순열을 구한 뒤 소수 여부를 판단합니다.
// 시간제한: 2초, 메모리제한:4MB
public class Main {
	// 전역변수 선언
	static int n;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];

		// 중복순열 시작
		function(0, 0);
	}

	// 중복순열 구하고 해당 숫자가 신기한 소수인지 판별
	static void function(int cnt, int number) {
		// 현재 1~n자리 수의 소수 여부를 판별하고 아니면 가지치기
		if (cnt > 0 && !isPrime(number)) {
			return;
		}

		// n자리수가 완성되면 신기한 소수임
		if (cnt == n) {
			System.out.println(number);
			return;
		}

		// 1부터 9까지 각 자리수에 숫자를 모두 사용합니다.
		for (int i = 1; i <= 9; i++) {
			numbers[cnt] = i;
			int next = number * 10 + i;
			function(cnt + 1, next);
		}
	}

	// 소수 여부를 판단하는 함수
	static boolean isPrime(int num) {
		// 2보다 작으면 소수가 아니라는 점 주의하기
		if (num < 2)
			return false;

		// 2~num까지 제곱근의 모든 수로 나눠보고 나눠지면 소수가 아님
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}

		// 조건에 걸리지 않으면 소수
		return true;
	}
}
