import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 농장의 크기 입력
            int n = Integer.parseInt(br.readLine());

            // 농작물 가치 입력
            int[][] d = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    d[i][j] = s.charAt(j) - '0';
                }
            }

            // 수익 구하기
            int ans = 0;
            int mid = n / 2;
            int start = mid, end = mid;
            for (int i = 0; i < n; i++) {
                // 해당 수익 다 더하기
                for (int j = start; j <= end; j++) {
                    ans += d[i][j];
                }
                // 중앙 점 기준으로 범위 조정
                if (i < mid) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}