import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 카드 숫자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 합 다 구하기
            int[] d = new int[n + m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    d[i + j]++;
                }
            }

            // 최빈 값 다 구하기
            int maxValue = 0;
            for (int i = 0; i < d.length; i++) {
                if (d[i] > maxValue) {
                    maxValue = d[i];
                }
            }

            // 답 출력하기
            System.out.printf("#%d ", tc);
            for (int i = 0; i < d.length; i++) {
                if (d[i] == maxValue) {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        }
    }
}
