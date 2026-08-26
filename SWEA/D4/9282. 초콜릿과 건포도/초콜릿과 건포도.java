import java.util.*;
import java.io.*;

public class Solution {
    static long[][] sum;
    static long[][][][] dp;

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 초콜릿 크기 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 누적합, 메모이제이션 생성
            sum = new long[n + 1][m + 1];
            dp = new long[n][m][n][m];

            // 건포도 개수 입력 및 누적합 계산
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    sum[i][j] = value + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }

            // 아직 계산하지 않은 상태를 -1로 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        Arrays.fill(dp[i][j][k], -1);
                    }
                }
            }

            // 전체 초콜릿을 자르는 최소 비용 출력
            System.out.printf("#%d %d\n", tc, cut(0, 0, n - 1, m - 1));
        }
    }

    // 최소 비용
    static long cut(int r1, int c1, int r2, int c2) {
        // 더 이상 자를 필요 없을 때
        if (r1 == r2 && c1 == c2) return 0;

        // 이미 계산한 값이면
        if (dp[r1][c1][r2][c2] != -1) return dp[r1][c1][r2][c2];

        // 현재 영역의 건포도 총합
        long total = sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1];

        // 최소 비용 초기화
        long min = Long.MAX_VALUE;

        // 가로로 자르는 모든 경우 확인
        for (int i = r1; i < r2; i++) {
            long cost = cut(r1, c1, i, c2) + cut(i + 1, c1, r2, c2) + total;
            min = Math.min(min, cost);
        }

        // 세로로 자르는 모든 경우 확인
        for (int i = c1; i < c2; i++) {
            long cost = cut(r1, c1, r2, i) + cut(r1, i + 1, r2, c2) + total;
            min = Math.min(min, cost);
        }

        // 계산한 최소 비용 저장
        dp[r1][c1][r2][c2] = min;
        return min;
    }
}