import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p') {
				if (i + 2 > s.length()) {
                    System.out.print("NO");
                    return;
                }
				String sub = s.substring(i, i + 2);
				if (sub.equals("pi")) {
					i++;
					continue;
				} else {
					System.out.print("NO");
					return;
				}
			} else if (s.charAt(i) == 'k') {
				if (i + 2 > s.length()) {
                    System.out.print("NO");
                    return;
                }
				String sub = s.substring(i, i + 2);
				if (sub.equals("ka")) {
					i++;
					continue;
				} else {
					System.out.print("NO");
					return;
				}
			} else if (s.charAt(i) == 'c') {
				if (i + 3 > s.length()) {
                    System.out.print("NO");
                    return;
                }
				String sub = s.substring(i, i + 3);
				if (sub.equals("chu")) {
					i += 2;
					continue;
				} else {
					System.out.print("NO");
					return;
				}
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.print("YES");
	}
}
