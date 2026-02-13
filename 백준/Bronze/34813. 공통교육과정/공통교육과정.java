import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String s = br.readLine();

		// 판단 후 출력
		if (s.charAt(0) == 'F') {
			System.out.print("Foundation");
		} else if (s.charAt(0) == 'C') {
			System.out.print("Claves");
		} else if (s.charAt(0) == 'V') {
			System.out.print("Veritas");
		} else if (s.charAt(0) == 'E') {
			System.out.print("Exploration");
		}
	}
}
