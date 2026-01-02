import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문제 해결 수, 유니온, 최고 레벨
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 조건에 맞게 답 출력
		if (a >= 1000) {
			if (b >= 8000 || c >= 260) {
				System.out.println("Very Good");
			} else {
				System.out.println("Good");
			}
		} else {
			System.out.println("Bad");
		}
	}
}
