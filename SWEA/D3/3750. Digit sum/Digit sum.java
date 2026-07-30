import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 첫 자연수 입력
            long n = Long.parseLong(br.readLine());

            // 한 자리가 될때까지 반복
            while (n >= 10) {
                long sum = 0;
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }
                n = sum;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, n);
        }
    }
}