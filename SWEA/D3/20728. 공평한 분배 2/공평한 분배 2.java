import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 주머니 수, 나눠 줄 주머니 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 주머니 속 사탕의 수
            int[] d = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(d);

            // 최솟값 구하기
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= n - m; i++) {
                int diff = d[i + m - 1] - d[i];
                ans = Math.min(ans, diff);
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}