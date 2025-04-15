import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컨베이어의 길이, 내구도가 0인 칸의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 로봇이 올라간 상태를 저장하기 위한 큐
		int[] robot = new int[n];

		// 벨트 내구도 배열
		int[] line1 = new int[n];
		int[] line2 = new int[n];

		// 2n 만큼의 벨트 내구도 정보 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			line1[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n - 1; i >= 0; i--) {
			line2[i] = Integer.parseInt(st.nextToken());
		}

		// 답을 저장할 변수, 내구도가 0인 칸의 수를 저장할 변수
		int ans = 0;
		int countZero = 0;

		// 종료 조건이 만족할 때까지 시뮬레이션
		while (true) {
			// 0인 칸이 k개 이상이면 종료
			if (countZero >= k) {
				break;
			}

			// 답 증가하기
			ans++;

			// 컨베이어 회전 시키기
			int tmp = line1[n - 1];
			for (int i = n - 1; i >= 1; i--) {
				line1[i] = line1[i - 1];
			}
			line1[0] = line2[0];
			for (int i = 0; i < n - 1; i++) {
				line2[i] = line2[i + 1];
			}
			line2[n - 1] = tmp;

			// 컨베이어 벨트 회전에 맞게 로봇도 회전 ==> 이거 빼먹어서 gpt한테 물어봐서 찾음
			for (int i = n - 1; i >= 1; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = 0;
			robot[n - 1] = 0;

			// 이동할 수 있는 로봇이 있으면 이동
			for (int i = n - 2; i >= 0; i--) {
				// 다음 칸 내구도
				int next = line1[i + 1];

				// 로봇 이동 조건: 다음 칸에 로봇이 없어야 하고, 내구도가 1 이상 남아있어야함
				if (i + 1 < n && robot[i] == 1 && robot[i + 1] == 0 && next != 0) {
					// 로봇 이동, 마지막칸이 아닐 경우, 내구도 감소
					if (i != n - 1) {
						robot[i] = 0;
						robot[i + 1] = 1;
						line1[i + 1]--;
						if (line1[i + 1] == 0)
							countZero++;
					}
					// 로봇 이동, 마지막 칸이면 내려버림
					else {
						robot[i] = 0;
					}
				}
			}
			robot[n - 1] = 0;

			// 새로운 로봇 올리기, 0이 아닐때만
			if (line1[0] > 0) {
				robot[0] = 1;
				line1[0]--;
				if (line1[0] == 0)
					countZero++;
			}
		}

		// 답 출력하기
		System.out.print(ans);
	}
}