import java.util.*;
import java.io.*;

// 만약, 정답이 3보다 큰 값이면 -1을 출력한다. 또, 불가능한 경우에도 -1을 출력한다.
// 사다리 1개일때 모든 경우와 사다리 2개 추가했을 때 모든 경우를 구해서 각각 시뮬레이션 돌리면 될듯
public class Main {
	// 전역 변수 선언부
	static int n, m, h;
	static int[][] d;

	// 사다리가 놓일 수 있는 위치를 저장할 리스트
	static List<int[]> ladder = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세로선의 수, 가로선의 수, 세로선마다 가로선을 놓을 수 있는 위치 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		// 사다리 공간 정보 저장할 배열 생성
		d = new int[h + 1][n + 1];

		// 가로선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
		}

		// 사다리가 놓일 수 있는 위치 확인하기, 이때 좌우로 사다리가 있으면 놓을 수 없음
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if (d[i][j] == 0 && d[i][j + 1] == 0 && (j == 1 || d[i][j - 1] == 0)) {
					ladder.add(new int[] { i, j });
				}
			}
		}

		// 0개 추가했을때 시뮬레이션 바로 돌려보기
		simulation(0);

		// 사다리 하나 추가했을때
		plusLadder(0, 1);

		// 사다리 두개 추가했을때
		plusLadder(0, 2);

		// 사다리 세개 추가했을때
		plusLadder(0, 3);

		// 여기까지오면 어차피 안되거나 3보다 큰거니까 -1 출력
		System.out.println(-1);
	}

	// 사다리 추가하는 메서드, 이때 좌 우로 사다리가 존재하면 추가할 수 없음
	static void plusLadder(int count, int target) {
		// 원하는 숫자만큼 사다리를 놓았으면
		if (count == target) {
			simulation(target);
			return;
		}

		// 사다리를 놓을 수 있는 모든 위치에 대해
		for (int i = 0; i < ladder.size(); i++) {
			int x = ladder.get(i)[0];
			int y = ladder.get(i)[1];

			// 좌우 충돌하면 스킵
			if (d[x][y + 1] == 1 || (y > 1 && d[x][y - 1] == 1))
				continue;

			// 현재 위치에 사다리 놓기
			d[x][y] = 1;

			// 현재 위치 다음부터 탐색하도록 리스트 자름
			List<int[]> nextLadder = ladder.subList(i + 1, ladder.size());
			List<int[]> backup = ladder;
			ladder = nextLadder;

			plusLadder(count + 1, target);

			// 원상복구
			d[x][y] = 0;
			ladder = backup;
		}
	}

	// 각 사다리가 정해지면 시뮬레이션 돌릴 메서드
	static void simulation(int count) {
		// 각 라인에서 출발해서
		for (int i = 1; i <= n; i++) {
			// 현재 탐색중인 라인
			int line = i;

			// 내려가면서 탐색하는데
			for (int j = 1; j <= h; j++) {
				// 사다리로 오른쪽 전환
				if (line < n && d[j][line] == 1) {
					line++;
				}
				// 사다리로 왼쪽 전환
				else if (line > 1 && d[j][line - 1] == 1) {
					line--;
				}
			}

			// 다른 줄이면 return
			if (line != i) {
				return;
			}
		}

		// 가능한 경우면 출력하고 종료
		System.out.println(count);
		System.exit(0);
	}
}
