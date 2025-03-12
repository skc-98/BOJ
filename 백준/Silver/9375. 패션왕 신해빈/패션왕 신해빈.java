import java.util.*;
import java.io.*;

// 아이디어
// 옷의 종류별로 수를 세서 종류별로 입을 수 있는 횟수에 벗는 경우까지 다 곱하고
// 모두 벗은 경우 1을 빼주면 답이 됩니다.
public class Main{
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 입력
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 의상 수 입력
			int n = Integer.parseInt(br.readLine());

			// 의상 입력하고 맵에 넣기
			Map<String, Integer> mp = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String b = st.nextToken();
				mp.put(b, mp.getOrDefault(b, 0) + 1);
			}

			// 옷의 가짓수+안입는 경우까지 해서 다 곱해주면 됩니다.
			int ans = 1;
			for (String iter : mp.keySet()) {
				ans *= (mp.get(iter) + 1);
			}
			// 모두 벗은 경우 제거
			ans--;

			// 답 출력하기
			System.out.println(ans);
		}
	}
}
