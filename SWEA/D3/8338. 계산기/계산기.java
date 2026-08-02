import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 수의 수
            int n = Integer.parseInt(br.readLine());

            // 정수 입력
            int[] d = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 합과 곱 중에 큰거
            int ans = d[0];
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans + d[i], ans * d[i]);
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}