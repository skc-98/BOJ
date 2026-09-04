import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // n과 x 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String x = st.nextToken();

            // 각 자리 숫자합 나눈 나머지 계산
            int ans = 0;
            for (int i = 0; i < x.length(); i++) {
                ans += (x.charAt(i) - '0');
                ans %= n - 1;
            }

            // 결과 출력
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}