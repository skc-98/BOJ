import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 윗줄
		for (int i = 0; i < n + 2; i++) {
			System.out.print("@");
		}
		System.out.println();

		// 중간 출력하기
		for (int i = 0; i < n; i++) {
			System.out.print("@");
			for (int j = 0; j < n; j++) {
				System.out.print(" ");
			}
			System.out.println("@");
		}

		// 아랫줄
		for (int i = 0; i < n + 2; i++) {
			System.out.print("@");
		}
	}
}
