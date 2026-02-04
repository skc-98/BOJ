import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 가위바위보 횟수 입력
			int n = Integer.parseInt(br.readLine());

			// 가위바위보 진행하면서 점수 세기
			int player1 = 0, player2 = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String p1 = st.nextToken();
				String p2 = st.nextToken();

				// 무승부인 경우
				if (p1.equals(p2)) {
					continue;
				}

				// 가위
				if (p1.equals("S")) {
					if (p2.equals("R"))
						player2++;
					else if (p2.equals("P"))
						player1++;
				}

				// 바위
				else if (p1.equals("R")) {
					if (p2.equals("S"))
						player1++;
					else if (p2.equals("P"))
						player2++;
				}

				// 보
				else if (p1.equals("P")) {
					if (p2.equals("R"))
						player1++;
					else if (p2.equals("S"))
						player2++;
				}
			}

			// 점수에 따라 결과 출력
			if (player1 == player2) {
				System.out.println("TIE");
			} else if (player1 > player2) {
				System.out.println("Player 1");
			} else if (player1 < player2) {
				System.out.println("Player 2");
			}
		}
	}
}
