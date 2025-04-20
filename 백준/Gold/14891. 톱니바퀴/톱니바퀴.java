import java.util.*;
import java.io.*;

// 맞닿는 부분은 2번과 6번 톱니
// 두 톱니의 극이 다르면 반대 방향, 같으면 회전 안 함
public class Main {
	// 덱의 특정 인덱스의 극 정보를 반환할 메서드
	static int idx(Deque<Integer> dq, int n) {
		int i = 0;
		for (int iter : dq) {
			if (i == n) {
				return iter;
			}
			i++;
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 톱니바퀴의 상태를 저장할 덱
		Deque<Integer>[] dq = new ArrayDeque[4];
		for (int i = 0; i < 4; i++) {
			dq[i] = new ArrayDeque<>();
		}

		// 4줄의 톱니바퀴 상태 입력
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				dq[i].addLast(Character.getNumericValue(s.charAt(j)));
			}
		}

		// 회전 수 입력
		int round = Integer.parseInt(br.readLine());

		// 회전 정보 입력
		for (int i = 0; i < round; i++) {
			// 회전시키는 톱니바퀴 번호, 방향 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1; // 여기 주의해야함 0-based 인덱스임
			int dir = Integer.parseInt(st.nextToken());

			// 회전 여부를 저장할 배열, 시계 방향은 1, 반시계 방향은 -1
			int[] isTurn = new int[4];

			// 해당 톱니바퀴 회전여부 갱신
			isTurn[num] = dir;

			// 톱니바퀴 기준 왼쪽 회전
			for (int j = num - 1; j >= 0; j--) {
				// 오른쪽 톱니바퀴가 회전 하는 경우만 판별
				if (isTurn[j + 1] == 1 || isTurn[j + 1] == -1) {
					// 왼쪽 2번과 오른쪽 6번이 다르면
					if (idx(dq[j], 2) != idx(dq[j + 1], 6)) {
						// 오른쪽에 있는 톱니의 반대 방향으로 회전 방향 설정
						if (isTurn[j + 1] == 1) {
							isTurn[j] = -1;
						} else if (isTurn[j + 1] == -1) {
							isTurn[j] = 1;
						}
					}
				}

				// 회전 안하면 멈추기
				else
					break;
			}

			// 톱니바퀴 기준 오른쪽 회전
			for (int j = num + 1; j < 4; j++) {
				// 왼쪽 톱니바퀴가 회전 하는 경우만 판별
				if (isTurn[j - 1] == 1 || isTurn[j - 1] == -1) {
					// 왼쪽 2번과 오른쪽 6번이 다르면
					if (idx(dq[j - 1], 2) != idx(dq[j], 6)) {
						// 왼쪽에 있는 톱니의 반대 방향으로 회전 방향 설정
						if (isTurn[j - 1] == 1) {
							isTurn[j] = -1;
						} else if (isTurn[j - 1] == -1) {
							isTurn[j] = 1;
						}
					}
				}

				// 회전 안하면 멈추기
				else
					break;
			}

			// 회전 정보에 따라 톱니바퀴 회전
			for (int j = 0; j < 4; j++) {
				// 반시계 방향 회전일 경우
				if (isTurn[j] == -1) {
					int tmp = dq[j].peekFirst();
					dq[j].pollFirst();
					dq[j].addLast(tmp);
				}

				// 시계 방향 회전일 경우
				else if (isTurn[j] == 1) {
					int tmp = dq[j].peekLast();
					dq[j].pollLast();
					dq[j].addFirst(tmp);
				}
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 점수 계산하기
		for (int i = 0; i < 4; i++) {
			// 현재 톱니바퀴의 12시 방향
			int top = dq[i].peekFirst();

			// S극일때만 점수 더하기
			if (top == 1) {
				ans += (Math.pow(2, i));
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
