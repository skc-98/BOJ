import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int ans = 0;
		boolean[] d = new boolean[5000];
		for (int i = 0; i < n; i++) {
			for (int j = ans; j < ans + m; j++) {
				d[j] = true;
			}
			ans += (m + 5);
		}

		int ansIdx = 0;
		while (true) {
			if (d[ansIdx] == false) {
				System.out.println(ansIdx);
				return;
			}
			ansIdx += k;
		}
	}
}
