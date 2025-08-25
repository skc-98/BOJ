import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 센서의 개수, 집중국의 개수 입력
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 센서 배열
		int[] d = new int[n];

		// 센서의 좌표 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 센서 정렬
		Arrays.sort(d);

		// 센서간 차이 저장
		List<Integer> diff = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			diff.add(d[i] - d[i - 1]);
		}

		// 차이도 정렬
		Collections.sort(diff);

		// 답 변수
		int ans = 0;

		// m-1개의 집중국 수만큼 빼고 합 구하기
		for (int i = 0; i < diff.size() - m + 1; i++) {
			ans += diff.get(i);
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
