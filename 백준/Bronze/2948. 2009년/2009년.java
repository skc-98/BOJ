import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] marr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] dayArr = { "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday" };

		int day = sc.nextInt();
		int month = sc.nextInt();

		int ans = 0;
		for (int i = 0; i < month - 1; i++) {
			ans += marr[i];
		}
		ans += day;

		System.out.println(dayArr[(ans-1) % 7]);
		sc.close();
	}
}
