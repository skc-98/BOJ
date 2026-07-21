import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 정수 입력
            int n = Integer.parseInt(br.readLine());

            // 답 구하기
            String ans = "No";
            for (int i = 1; i <= 9; i++) {
                if (n % i == 0 && n / i >= 1 && n / i <= 9) {
                    ans = "Yes";
                    break;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %s\n", tc, ans);
        }
    }
}
