import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 반지름 입력
            int n = Integer.parseInt(br.readLine());

            // 격자점의 수 구하기
            int ans = 0;
            for (int i = -n; i <= n; i++) {
                for (int j = -n; j <= n; j++) {
                    if (i * i + j * j <= n * n) {
                        ans++;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}