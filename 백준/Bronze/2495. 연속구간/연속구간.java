import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세 개의 여덟 자리 양의 정수 입력
		String[] d = new String[3];
		d[0] = br.readLine();
		d[1] = br.readLine();
		d[2] = br.readLine();

		// 연속하는 구간 찾기
		for (int i = 0; i < 3; i++) {
			int maxCount = 1;
			int count = 1;

			for (int j = 1; j < d[i].length(); j++) {
				if (d[i].charAt(j) == d[i].charAt(j - 1))
					count++;
				else
					count = 1;
				if (count > maxCount)
					maxCount = count;
			}

			System.out.println(maxCount);
		}
	}
}
