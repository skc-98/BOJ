import java.util.*;
import java.io.*;

public class Main {
	// 전역 변수 선언
	static int n, range;
	static List<List<Integer>> li;
	static boolean[] visit;
	static int ans = 0;
	static int[] d;

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 수, 거리 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());

		// 인접 리스트 생성
		li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			li.add(new ArrayList<>());
		}
		visit = new boolean[n];
		d=new int[n];

		// 부모 자식 관계 입력
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li.get(a).add(b);
			li.get(b).add(a);
		}
		
		// 각 정점의 사과 여부 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			d[i]=Integer.parseInt(st.nextToken());
		}

		// DFS 탐색
		dfs(0, 0);

		// 답 출력하기
		System.out.print(ans);
	}

	// DFS 메서드
	static void dfs(int now, int depth) {
		if (depth > range) {
			return;
		}
		
		visit[now]=true;
		if(d[now]==1) ans++;

		for (int i = 0; i < li.get(now).size(); i++) {
			if (!visit[li.get(now).get(i)]) {
				dfs(li.get(now).get(i), depth + 1);
			}
		}
	}
}
