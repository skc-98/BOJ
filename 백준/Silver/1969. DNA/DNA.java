import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// DNA 수, 문자열 길이
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// DNA 배열
		String[] dna = new String[n];

		// DNA 입력
		for (int i = 0; i < n; i++) {
			dna[i] = br.readLine();
		}

		// 결과DNA
		String result = "";
		int totalDistance = 0;

		// 각 열 별로 가장 많이 등장한 문자 찾기
		for (int i = 0; i < m; i++) {
			int[] count = new int[4];
			for (int j = 0; j < n; j++) {
				char a = dna[j].charAt(i);
				if (a == 'A')
					count[0]++;
				else if (a == 'C')
					count[1]++;
				else if (a == 'G')
					count[2]++;
				else if (a == 'T')
					count[3]++;
			}

			// 가장 많이 나온 문자 선택
			int maxCount = -1;
			int idx = 0;
			for (int j = 0; j < 4; j++) {
				if (count[j] > maxCount) {
					maxCount = count[j];
					idx = j;
				}
			}

			// 인덱스 가지고 문자 선택
			if (idx == 0)
				result += 'A';
			else if (idx == 1)
				result += 'C';
			else if (idx == 2)
				result += 'G';
			else if (idx == 3)
				result += 'T';

			// distance 누적
			totalDistance += (n - maxCount);
		}

		// 답 출력하기
		System.out.println(result);
		System.out.println(totalDistance);
	}
}