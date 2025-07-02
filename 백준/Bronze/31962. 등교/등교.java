import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int latestStart = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 정류장에서 출발까지 시간
			int t = Integer.parseInt(st.nextToken()); // 정류장에서 학교까지 시간

			if (s + t <= x) {
				latestStart = Math.max(latestStart, s);
			}
		}
		System.out.println(latestStart);
	}
}
