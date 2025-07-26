import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연도 입력
		int n = Integer.parseInt(br.readLine());

		if (n <= 100000 && n % 2024 == 0) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
	}
}
