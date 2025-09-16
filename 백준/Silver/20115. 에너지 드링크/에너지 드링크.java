import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 에너지 드링크의 수
		int n = Integer.parseInt(br.readLine());

		// 에너지 드링크 배열, 최대 값
		double[] d = new double[n];
		double maxDrink = 0;

		// 에너지 드링크 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
			maxDrink = Math.max(maxDrink, d[i]);
		}

		// 답 변수
		double ans = 0.0d;
		ans += maxDrink;
		for (int i = 0; i < n; i++) {
			if (d[i] == maxDrink)
				continue;
			ans += (d[i] / 2);
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
