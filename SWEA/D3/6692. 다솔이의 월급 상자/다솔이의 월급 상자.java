import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 받을 수 있는 월급과 확률의 수
            int n = Integer.parseInt(br.readLine());

            // 확률 평균 구하기
            double ans = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double p = Double.parseDouble(st.nextToken());
                double x = Double.parseDouble(st.nextToken());
                ans += (p * x);
            }

            // 답 출력하기
            System.out.printf("#%d %.6f\n", tc, ans);
        }
    }
}
