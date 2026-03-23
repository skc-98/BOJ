import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 재료 수
		int n = Integer.parseInt(br.readLine());

		// 재료 배열
		String[] d = new String[n];

		// 재료 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = st.nextToken();
		}

		// 레시피 재료 셋에 넣기
		Set<String> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			set.add(st.nextToken());
		}

		// 빠진 재료 출력
		for (int i = 0; i < n; i++) {
			if (!set.contains(d[i])) {
				System.out.println(d[i]);
				break;
			}
		}
	}
}
