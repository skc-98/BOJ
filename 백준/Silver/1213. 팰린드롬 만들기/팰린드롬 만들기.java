import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		// 배열에 해당 알파벳 증가
		int[] alpha = new int[101];
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i)]++;
		}

		// 불가능 체크
		int odd = 0;
		char oddalpha = 'a';
		for (int i = 'A'; i <= 'Z'; i++) {
			if (alpha[i] % 2 == 1) {
				oddalpha=(char)(i);
				odd++;
			}
		}
		if (odd > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		// 펠린드롬 만들기
		char[] ans=new char[s.length()];
		ans[s.length()/2]=oddalpha;
		alpha[oddalpha]--;
		int start=0;
		int end=s.length()-1;
		for(int i='A'; i<='Z'; i++) {
			while(alpha[i]>0) {
				ans[start]=(char)i;
				ans[end]=(char)i;
				start++;
				end--;
				alpha[i]-=2;
			}
		}
		for(int i=0; i<s.length(); i++) {
			System.out.print(ans[i]);
		}
	}
}
