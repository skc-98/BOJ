import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 크기
			int n = Integer.parseInt(br.readLine());

			// J박스 출력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != 0 && i != n - 1 && j != 0 && j != n - 1) {
						System.out.print('J');
					} else {
						System.out.print('#');
					}
				}
				System.out.println();
			}

			// 한줄 띄우기
			System.out.println();
		}
	}
}
