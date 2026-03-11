import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 받으면서 사진 판별하기
		for (int i = 0; i < 15; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 15; j++) {
				String now = st.nextToken();

				// 춘배면
				if (now.equals("w")) {
					System.out.println("chunbae");
					return;
				} else if (now.equals("b")) {
					System.out.println("nabi");
					return;
				} else if (now.equals("g")) {
					System.out.println("yeongcheol");
					return;
				}
			}
		}
	}
}
