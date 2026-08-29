import java.util.*;
import java.io.*;

public class Solution {
    // 전역 변수 선언부
    static int n, m, answer;
    static int[] d;

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 자연수의 수, 합 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 자연수 수열 입력
            st = new StringTokenizer(br.readLine());
            d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 부분 수열 탐색
            answer = 0;
            dfs(0, 0);

            // 결과 출력
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

    // 모든 경우 탐색
    static void dfs(int depth, int sum) {
        // 모든 자연수를 확인한 경우
        if (depth == n) {
            // 부분 수열의 합이 m인 경우
            if (sum == m) {
                answer++;
            }
            return;
        }

        // 현재 자연수를 선택하는 경우
        dfs(depth + 1, sum + d[depth]);

        // 현재 자연수를 선택하지 않는 경우
        dfs(depth + 1, sum);
    }
}