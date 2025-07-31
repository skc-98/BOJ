import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 풍선 수 입력
		int n = Integer.parseInt(br.readLine());

		// 답을 저장할 변수
		int ans = 0;

		// 화살 배열, 풍선 배열 생성
		int[] arrow = new int[1000001];
		int[] balloon = new int[n];

		// 풍선 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			balloon[i] = Integer.parseInt(st.nextToken());
		}

		// 각 풍선 돌면서 화살 수 계산하기
		for (int i = 0; i < n; i++) {
			if (arrow[balloon[i]] > 0) {
				arrow[balloon[i]]--;
				arrow[balloon[i] - 1]++;
			} else if (arrow[balloon[i]] == 0) {
				ans++;
				arrow[balloon[i] - 1]++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
