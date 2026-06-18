import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());

        // dp 구해두기

        // 파도반 수열 구해두기
        long[] dp = new long[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        for (int i = 5; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        // 각 테케의 답 구하기
        for (int tc = 1; tc <= tcn; tc++) {
            // 구하고 싶은 수열 번호
            int n = Integer.parseInt(br.readLine());

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, dp[n - 1]);
        }
    }
}
