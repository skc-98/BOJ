import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 위치 입력
            long n = Long.parseLong(br.readLine());

            // 2의 배수를 제거해 홀수로 만든다
            while (n % 2 == 0) {
                n /= 2;
            }

            // 4로 나눈 나머지로 값 판별
            int ans = 0;
            if (n % 4 == 3) {
                ans = 1;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
