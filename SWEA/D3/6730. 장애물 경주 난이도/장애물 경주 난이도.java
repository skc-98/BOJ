import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 장애물 수
            int n = Integer.parseInt(br.readLine());

            // 장애물 입력
            int[] d = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 장애물 높이 차 구하기
            int max = 0, min = 0;
            for (int i = 1; i < n; i++) {
                int diff = d[i - 1] - d[i];
                max = Math.max(max, diff);
                min = Math.min(min, diff);
            }

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, Math.abs(min), max);
        }
    }
}
