import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 숫자 입력
		int ans = Integer.parseInt(br.readLine());

		// 끝날때까지 반복
		while (true) {
			String op = br.readLine();

			if (op.equals("="))
				break;

			int num = Integer.parseInt(br.readLine());

			if (op.equals("+"))
				ans += num;
			else if (op.equals("-"))
				ans -= num;
			else if (op.equals("*"))
				ans *= num;
			else if (op.equals("/"))
				ans /= num;
		}

		// 답변 출력하기
		System.out.println(ans);
	}
}
