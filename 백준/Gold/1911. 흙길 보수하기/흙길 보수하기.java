import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 웅덩이 정보 저장할 리스트
		List<int[]> li = new ArrayList<>();

		// 웅덩이 정보 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li.add(new int[] { a, b });
		}

		// 시작점 기준 정렬(람다식 사용)
		li.sort((d1, d2) -> d1[0] - d2[0]);

		// 답 저장할 변수
		int ans = 0;

		// 각 웅덩이 순회하면서 판자 수 구하기
		int endPoint = 0;
		for (int i = 0; i < li.size(); i++) {
			int begin = li.get(i)[0];
			int end = li.get(i)[1];

			// 마지막 지점보다 빠르면 갱신
			if (endPoint > begin) {
				begin = endPoint;
			}

			// 판자 수 더하면서 끝 지점 구하기 => 수식처리 귀찮음 시간초과면 여기
			while (end > begin) {
				begin += m;
				ans++;
				endPoint = begin;
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
