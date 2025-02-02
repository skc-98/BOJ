import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] xList = new int[n];
		int[] yList = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xList[i] = Integer.parseInt(st.nextToken());
			yList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xList);
		Arrays.sort(yList);

		int ansX = xList[n / 2];
		int ansY = yList[n / 2];

		long distance = 0;
		for (int i = 0; i < n; i++) {
			distance += Math.abs(xList[i] - ansX) + Math.abs(yList[i] - ansY);
		}
		System.out.print(distance);
	}
}
