import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (st.empty()) {
				st.push(s.charAt(i));
				continue;
			} else if (st.peek() == '(') {
				if(s.charAt(i)=='(') st.push(s.charAt(i));
				else st.pop();
			}
			else if(st.peek()==')') st.push(s.charAt(i));
		}
		System.out.println(st.size());
	}
}
