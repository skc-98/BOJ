import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int score1 = 0, score2 = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (s.equals("D"))
				score1++;
			else
				score2++;
			if (Math.abs(score1 - score2) >= 2) {
				break;
			}
		}
		System.out.printf("%d:%d", score1, score2);
	}
}
