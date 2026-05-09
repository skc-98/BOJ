import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 다양성 측정할 수
            int n = Integer.parseInt(br.readLine());

            // 다양성 측정
            int[] d = new int[10];
            while (n > 0) {
                int now = n % 10;
                n /= 10;
                d[now]++;
            }

            // 답 구하기
            int ans = 0;
            for (int i = 0; i <= 9; i++) {
                if (d[i] != 0) ans++;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
