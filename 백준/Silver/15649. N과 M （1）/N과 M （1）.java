import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static List<Integer> li = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n + 1];
		func(0);
	}

	public static void func(int num) {
		if (num == m) {
			for (int iter : li) {
				System.out.print(iter + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				li.add(i);
				func(num + 1);
				li.remove(li.size() - 1);
				visit[i] = false;
			}
		}
	}
}
