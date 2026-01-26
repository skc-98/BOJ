import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 가로 세로랑 공백 길이
		int size = 5 * n;
		int mid = 3 * n;

		// 골뱅이 찍기
		for (int i = 0; i < size; i++) {
			// 첫줄, 마지막줄
			if (i < n || i >= 4 * n) {
				for (int j = 0; j < size; j++) {
					System.out.print('@');
				}
			}
			// 가운데 줄
			else {
				for (int j = 0; j < n; j++) {
					System.out.print('@');
				}
				for (int j = 0; j < mid; j++) {
					System.out.print(' ');
				}
				for (int j = 0; j < n; j++) {
					System.out.print('@');
				}
			}
			System.out.println();
		}
	}
}
