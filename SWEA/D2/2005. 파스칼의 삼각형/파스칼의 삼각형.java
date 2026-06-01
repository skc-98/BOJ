import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 파스칼 삼각형의 크기
            int n = Integer.parseInt(br.readLine());

            // 파스칼 삼각형 생성
            int[][] d = new int[n][n];
            for (int i = 0; i < n; i++) {
                d[i][0] = 1;
                d[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
                }
            }

            // 답 출력하기
            System.out.printf("#%d\n", tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.printf("%d ", d[i][j]);
                }
                System.out.println();
            }
        }
    }
}