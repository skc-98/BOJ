import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 배열 생성, 도시번호 1번부터니까 한칸씩 벌리기
		int[][] d = new int[n + 1][n + 1];

		// 경로 저장을 위해 3차원 형태로 리스트 생성
		List<List<List<Integer>>> route = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			List<List<Integer>> row = new ArrayList<>();
			for (int j = 0; j <= n; j++) {
				row.add(new ArrayList<>());
			}
			route.add(row);
		}

		// 배열 초기화
		for (int i = 0; i <= n; i++) {
			Arrays.fill(d[i], 9999999);
		}
		for (int i = 0; i <= n; i++) {
			d[i][i] = 0;
		}

		// 버스의 개수 입력
		int bus = Integer.parseInt(br.readLine());

		// 버스 경로와 시간 입력, 이때 같은 노선의 최소 비용 저장
		for (int i = 0; i < bus; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (d[start][end] > cost) {
				d[start][end] = cost;
				route.get(start - 1).get(end - 1).clear();
				route.get(start - 1).get(end - 1).add(start);
				route.get(start - 1).get(end - 1).add(end);
			}
		}

		// 플로이드 워샬
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;

					// 경유해서 가는게 더 빠른경우 갱신
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						route.get(i - 1).get(j - 1).clear();
						for (int p = 0; p < route.get(i - 1).get(k - 1).size(); p++) {
							route.get(i - 1).get(j - 1).add(route.get(i - 1).get(k - 1).get(p));
						}
						for (int p = 1; p < route.get(k - 1).get(j - 1).size(); p++) {
							route.get(i - 1).get(j - 1).add(route.get(k - 1).get(j - 1).get(p));
						}
					}
				}
			}
		}

		// 플로이드 완성 상태 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 9999999)
					System.out.print(0 + " ");
				else
					System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}

		// 경로 모음 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 경로가 없으면 0 출력
				if (route.get(i - 1).get(j - 1).isEmpty()) {
					System.out.println(0);
					continue;
				}

				// 해당하는 경로 출력
				System.out.print(route.get(i - 1).get(j - 1).size() + " ");
				for (int k = 0; k < route.get(i - 1).get(j - 1).size(); k++) {
					System.out.print(route.get(i - 1).get(j - 1).get(k) + " ");
				}
				System.out.println();
			}
		}
	}
}