import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 거슬러 줄 총 금액
            int n = Integer.parseInt(br.readLine());

            // 거스름 돈 구하기
            int[] d = new int[8];
            d[0] = n / 50000;
            n %= 50000;
            d[1] = n / 10000;
            n %= 10000;
            d[2] = n / 5000;
            n %= 5000;
            d[3] = n / 1000;
            n %= 1000;
            d[4] = n / 500;
            n %= 500;
            d[5] = n / 100;
            n %= 100;
            d[6] = n / 50;
            n %= 50;
            d[7] = n / 10;
            n %= 10;

            // 답 출력하기
            System.out.printf("#%d\n", tc);
            for (int i = 0; i < 8; i++) {
                System.out.print(d[i] + " ");
            }
            System.out.println();
        }
    }
}