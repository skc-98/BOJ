import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=n; i++) q.add(i);
		
		while(true) {
			if(q.size()==1) break;
			q.remove();
			q.add(q.peek());
			q.remove();
		}
		System.out.print(q.peek());
	}
}
