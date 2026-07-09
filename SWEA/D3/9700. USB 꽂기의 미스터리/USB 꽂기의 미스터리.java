import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 두 확률 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            double p = Double.parseDouble(st.nextToken());
            double q = Double.parseDouble(st.nextToken());

            // 확률 계산하기
            double s1 = (1 - p) * q;
            double s2 = p * (1 - q) * q;

            // 답 출력하기
            if (s1 < s2) {
                System.out.printf("#%d YES\n", tc);
            } else {
                System.out.printf("#%d NO\n", tc);
            }
        }
    }
}