import java.util.*;
import java.io.*;

public class Solution {
    // 전역 변수 선언부
    static List<Integer>[] li;
    static boolean[] visit;
    static int ans;
    static int n, m;

    static void dfs(int now, int cnt) {
        ans = Math.max(ans, cnt);

        for (int i = 0; i < li[now].size(); i++) {
            int next = li[now].get(i);

            if (!visit[next]) {
                visit[next] = true;
                dfs(next, cnt + 1);
                visit[next] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 정점, 간선의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 인접 리스트 생성
            li = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                li[i] = new ArrayList<>();
            }

            // 간선 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                li[a].add(b);
                li[b].add(a);
            }

            // 최장 거리 계산
            ans = 0;

            // 모든 정점에서 DFS
            for (int i = 1; i <= n; i++) {
                visit = new boolean[n + 1];
                visit[i] = true;
                dfs(i, 1);
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}