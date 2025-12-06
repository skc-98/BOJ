import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int ans = 0;
		String s = "";
		while ((s = br.readLine()) != null) {
			ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
