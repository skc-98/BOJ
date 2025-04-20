import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사과나무의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 1주는 횟수, 2주는 횟수 카운트
		int oneCount = 0;
		int twoCount = 0;

		// 각 나무의 정보 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			// 나무 입력
			int t = Integer.parseInt(st.nextToken());

			// 나무 높이를 2로 나눈 몫은 2주는 횟수, 나머지는 1주는 횟수로 카운트
			oneCount += (t % 2);
			twoCount += (t / 2);
		}

		// 이제 2씩 주는 횟수를 감소하면서 1씩 주는 횟수 2만큼 증가 반복
		while (true) {
			// 1씩 주는 날이 더 커져버리면 불가능한 경우
			if (oneCount > twoCount) {
				System.out.print("NO");
				break;
			}

			// 같아지면 가능한 경우임
			else if (oneCount == twoCount) {
				System.out.print("YES");
				break;
			}

			// twoCount는 1 감소, oneCount는 2증가
			twoCount--;
			oneCount += 2;
		}
	}
}
