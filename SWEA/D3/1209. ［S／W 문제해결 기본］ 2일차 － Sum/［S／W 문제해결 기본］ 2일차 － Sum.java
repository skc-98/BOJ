import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        for (int tc = 1; tc <= 10; tc++) {
            // 테스트 케이스의 번호
            int tcn = Integer.parseInt(br.readLine());

            // 100*100 저장
            int[][] d = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    d[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 최댓값 구하기
            int ans = 0;
            int cSum1 = 0;
            int cSum2 = 0;
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                int sum2 = 0;
                // 가로
                for (int j = 0; j < 100; j++) {
                    sum += d[i][j];
                }
                if (sum > ans) ans = sum;

                // 세로
                for (int j = 0; j < 100; j++) {
                    sum2 += d[j][i];
                }
                if (sum2 > ans) ans = sum2;

                // 대각선 합 구해두기
                cSum1 += d[i][i];
                cSum2 += d[i][99 - i];
            }

            // 대각선 두개 처리하기
            if (cSum1 > ans) ans = cSum1;
            if (cSum2 > ans) ans = cSum2;


            // 답 출력하기
            System.out.printf("#%d %d\n", tcn, ans);
        }
    }
}
