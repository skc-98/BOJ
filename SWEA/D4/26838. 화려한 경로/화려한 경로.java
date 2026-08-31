import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // n,m,k 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 각 정점의 색깔
            int[] color = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                color[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            // 그래프 생성
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a].add(b);
                graph[b].add(a);
            }

            // v에서 끝나고 mask의 색들을 사용한 경로의 개수
            long[][] dp = new long[n][1 << k];

            // 시작 정점 하나짜리 경로
            for (int i = 0; i < n; i++) {
                dp[i][1 << color[i]] = 1;
            }

            // 사용한 색깔 조합
            long answer = 0;
            for (int i = 1; i < (1 << k); i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[j][i] == 0) {
                        continue;
                    }

                    // 정점이 2개 이상인 경로만 정답에 포함
                    if (Integer.bitCount(i) >= 2) {
                        answer += dp[j][i];
                    }

                    // 현재 정점과 연결된 정점으로 이동
                    for (int next : graph[j]) {
                        int nextColor = color[next];
                        // 이미 사용한 색깔이면 이동 불가능
                        if ((i & (1 << nextColor)) != 0) {
                            continue;
                        }
                        int nextMask = i | (1 << nextColor);
                        dp[next][nextMask] += dp[j][i];
                    }
                }
            }

            // 결과 출력
            System.out.println(answer);
        }
    }
}
