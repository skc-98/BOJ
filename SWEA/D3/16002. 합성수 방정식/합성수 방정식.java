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

            // 합성수 찾기
            int ans1 = 0;
            int ans2 = 0;
            if (n % 2 == 0) {
                ans1 = n + 4;
                ans2 = 4;
            } else {
                ans1 = n + 9;
                ans2 = 9;
            }

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, ans1, ans2);
        }
    }
}