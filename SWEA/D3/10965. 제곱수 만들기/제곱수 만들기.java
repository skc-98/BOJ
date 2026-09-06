import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 자연수 입력
            int n = Integer.parseInt(br.readLine());

            // 소인수분해
            int temp = n, ans = 1;
            for (int i = 2; i * i <= temp; i++) {
                // 현재 소인수의 개수
                int cnt = 0;
                while (temp % i == 0) {
                    temp /= i;
                    cnt++;
                }

                // 소인수가 홀수면 한 번 더 곱하기
                if (cnt % 2 == 1) {
                    ans *= i;
                }
            }

            // 마지막으로 남은 소인수가 있으면 곱하기
            if (temp > 1) {
                ans *= temp;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}