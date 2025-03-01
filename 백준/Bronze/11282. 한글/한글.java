import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		// 한글 유니코드 시작값
		char first = '\uAC00'; // '가'
		// N번째 글자 찾기 (N은 1부터 시작하므로 N-1을 더함)
		char result = (char) (first + (n - 1));
		// 결과 출력
		System.out.println(result);
	}
}
