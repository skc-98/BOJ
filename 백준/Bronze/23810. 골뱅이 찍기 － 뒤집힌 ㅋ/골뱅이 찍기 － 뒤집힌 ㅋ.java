import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 제일 위쪽
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 5; j++) {
				System.out.print("@");
			}
			System.out.println();
		}

		// 사이
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("@");
			}
			System.out.println();
		}

		// 가운데
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 5; j++) {
				System.out.print("@");
			}
			System.out.println();
		}

		// 마지막
		for (int i = 0; i < n * 2; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
	}
}
