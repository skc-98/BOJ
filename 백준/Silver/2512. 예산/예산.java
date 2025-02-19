import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);

		int money = Integer.parseInt(br.readLine());

		int ans = 0;
		int start = 0, end = arr.get(arr.size() - 1);
		while (start <= end) {
			int mid = (start + end) / 2;
			int budget = 0;

			for (int i = 0; i < n; i++) {
				budget += Math.min(arr.get(i), mid);
			}
			if (budget <= money) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
