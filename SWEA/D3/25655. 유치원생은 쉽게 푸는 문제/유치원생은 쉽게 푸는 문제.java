import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 구멍의 수
            int n = Integer.parseInt(br.readLine());

            // 구멍이 1개인 경우 0
            if (n == 1) {
                System.out.println(0);
                continue;
            }

            // 홀수인 앞에 4
            if (n % 2 == 1) {
                System.out.print(4);
                n--;
            }

            // 남은 구멍은 8
            for (int i = 0; i < n / 2; i++) {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}