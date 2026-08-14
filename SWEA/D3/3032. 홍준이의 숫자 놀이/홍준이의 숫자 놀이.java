import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 두 자연수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 식을 만족하는 답 찾기
            long x0 = 1, y0 = 0, x1 = 0, y1 = 1;
            while (b != 0) {
                long q = a / b;
                long r = a % b;
                a = b;
                b = (int) r;

                long nx = x0 - q * x1;
                long ny = y0 - q * y1;
                x0 = x1;
                y0 = y1;
                x1 = nx;
                y1 = ny;
            }

            // 답 출력하기
            if (a != 1) {
                System.out.printf("#%d -1\n", tc);
            } else {
                System.out.printf("#%d %d %d\n", tc, x0, y0);
            }
        }
    }
}