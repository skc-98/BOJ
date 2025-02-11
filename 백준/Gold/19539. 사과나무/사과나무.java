import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt1 = 0, cnt2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			cnt2 += num / 2;
			cnt1 += num % 2;
		}

		while (true) {
			if (cnt2 < cnt1) {
				System.out.println("NO");
				return;
			} else if (cnt2 == cnt1) {
				System.out.println("YES");
				return;
			}
			cnt2--;
			cnt1 += 2;
		}
	}
}
