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

            // 연속된 자연수의 합 찾기
            int ans = 0;
            int now = 1;
            while (true) {
                int remain = n - now * (now - 1) / 2;
                if (remain <= 0) break;
                if (remain % now == 0) ans++;
                now++;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}