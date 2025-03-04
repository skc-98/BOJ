import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 선언
	static int n, m;
	static int[][] d;

	// 집과 치킨집의 좌표를 저장할 리스트
	static List<int[]> chicken = new ArrayList<>();
	static List<int[]> house = new ArrayList<>();

	static boolean[] visit;

	// 답을 저장할 변수
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n과 m 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// n*n 크기의 도시 정보 입력, 입력 받으면서 집과 치킨집의 좌표 저장
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
				if (d[i][j] == 1) {
					house.add(new int[] { i, j });
				} else if (d[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}

		// 도시의 치킨집 중 0 ~ m개를 골라 치킨 거리 구하면서 ans 갱신
		visit = new boolean[chicken.size()];
		for (int i = 0; i < m; i++) {
			func(i, 0);
		}

		// 정답 출력
		System.out.println(ans);
	}

	// 최대 0 ~ m개의 치킨집을 고르는 메서드
	static void func(int cnt, int start) {
		if (cnt == m) {
			// 치킨 거리 구하는 메서드 호출, 인덱스 정보는 visit 배열 true 여부로 판단하기
			calculate();
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			visit[i] = true;
			func(cnt + 1, i + 1);
			visit[i] = false;
		}
	}

	// 현재 선택된 치킨집은 폐업시키지 않는 치킨집이고 치킨 거리를 구해서 최솟값 갱신
	static void calculate() {
		int sum = 0;
		// 각 집에서 선택된 치킨집 사이의 거리 중 가장 짧은거 고르기
		for (int i = 0; i < house.size(); i++) {
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.size(); j++) {
				if (visit[j]) {
					dist = Math.min(dist, Math.abs(chicken.get(j)[0] - house.get(i)[0])
							+ Math.abs(chicken.get(j)[1] - house.get(i)[1]));
				}
			}
			sum += dist;
		}
		ans = Math.min(ans, sum);
	}
}
