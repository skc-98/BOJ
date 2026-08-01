import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 거리 입력
            int n = Integer.parseInt(br.readLine());

            // 거리에 따라 답 구하기
            int ans;
            if (n < 100) {
                ans = 0;
            } else if (n < 1000) {
                ans = 1;
            } else if (n < 10000) {
                ans = 2;
            } else if (n < 100000) {
                ans = 3;
            } else if (n < 1000000) {
                ans = 4;
            } else {
                ans = 5;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}