import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		int n = Integer.parseInt(br.readLine());

		// 찍기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 5; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
		for (int i = 0; i < n * 4; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
	}
}
