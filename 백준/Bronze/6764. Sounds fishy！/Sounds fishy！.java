import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수심 4개 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());

		// 답 출력하기
		if (a < b && b < c && c < d) {
			System.out.print("Fish Rising");
		} else if (a > b && b > c && c > d) {
			System.out.print("Fish Diving");
		} else if (a == b && b == c && c == d) {
			System.out.print("Fish At Constant Depth");
		} else {
			System.out.print("No Fish");
		}
	}
}
