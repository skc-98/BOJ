import java.util.*;
import java.io.*;

// 아이디어
// 길이가 n인 문자열에서 m인 부분 문자열을 추출하고 조건에 맞는지 확인해야하는 문제입니다.
// 슬라이딩 윈도우를 통해 최적화 된 시간에 해결할 수 있습니다.
// 시간제한: 2초, 메모리제한: 512MB

public class Main {
	// 각 문자의 등장 횟수를 저장할 배열
	static int[] d = new int[101];
	// 각 알파벳의 인덱스를 조회하기 위해 배열로 저장
	static char[] alpha = { 'A', 'C', 'G', 'T' };

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 전체문자열 길이:n, 부분 문자열의 길이: m
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 입력 받는 문자열: dna
		String dna = br.readLine();

		// 부분 문자열에 포함되어야 하는 A, C, G, T의 값
		st = new StringTokenizer(br.readLine());
		int[] count = new int[4];
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		// 가능한 비밀번호의 수: ans
		int ans = 0;

		// 첫 substring에 포함된 문자의 숫자 카운트
		for (int i = 0; i < m; i++) {
			d[dna.charAt(i)]++;
		}

		// 첫 조합이 가능한지 판별
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			if (d[alpha[i]] < count[i]) {
				check = true;
			}
		}
		if (!check)
			ans++;

		int slide = 0;
		while (true) {
			// 맨 앞의 문자열은 빼고 맨 뒤 문자열은 추가
			d[dna.charAt(slide)]--;
			if (slide + m > dna.length() - 1)
				break;
			d[dna.charAt(slide + m)]++;

			// 새로운 조합의 비밀번호 가능 여부 확인
			check = false;
			for (int i = 0; i < 4; i++) {
				if (d[alpha[i]] < count[i]) {
					check = true;
				}
			}
			if (!check) {
				ans++;
			}
			// slide 증가
			slide++;
		}

		// 답 출력
		System.out.print(ans);
	}
}
