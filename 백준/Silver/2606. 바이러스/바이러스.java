import java.util.*;
import java.io.*;

// 시작 바이러스는 항상 1번 컴퓨터에서 감염
public class Main {
	// 인접 리스트는 전역으로 선언
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 연결 된 컴퓨터 쌍의 수 입력
		int m = Integer.parseInt(br.readLine());

		// 인접 리스트 생성, 인덱스 1번부터 사용
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 인접 리스트에 각 연결 정보 저장
		for (int i = 0; i < m; i++) {
			// 연결 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향 연결 관계 추가
			list[a].add(b);
			list[b].add(a);
		}

		// DFS 탐색을 통해 1번 컴퓨터부터 감염 시작
		visit = new boolean[n + 1];
		dfs(1);

		// 이제 방문 한 컴퓨터는 모두 감염이니까 방문 배열 카운트, 이때 1번 컴퓨터는 제외
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (visit[i])
				ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}

	// 방문 배열
	static boolean[] visit;

	// DFS 탐색 메서드
	static void dfs(int n) {
		for (int i = 0; i < list[n].size(); i++) {
			// 아직 방문하지 않은 경우 방문 처리 후 DFS 재호출
			if (!visit[list[n].get(i)]) {
				visit[list[n].get(i)] = true;
				dfs(list[n].get(i));
			}
		}
		return;
	}
}
