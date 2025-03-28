import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			int n = Integer.parseInt(br.readLine());

			// 1은 열린상태 0은 닫힌상태
			int[] d = new int[n];
			int roundCount = 0;

			for (int i = 0; i < n; i++) {
				d[i] = 1;
			}

			for (int i = 2; i <= n; i++) {
				for (int j = i - 1; j < n; j += i) {
					if (d[j] == 1) {
						d[j] = 0;
					} else {
						d[j] = 1;
					}
				}
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				if (d[i] == 1) {
					count++;
				}
			}

			System.out.println(count);
		}
	}
}
