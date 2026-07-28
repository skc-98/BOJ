import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 최대 게임 수, 오늘 승률, 전체 승률
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 최대공약수 계산
            int x = a;
            int y = 100;
            while (y != 0) {
                int temp = x % y;
                x = y;
                y = temp;
            }

            // 통계 가능 여부 확인
            int game = 100 / x;
            boolean isPos = game <= n;
            if ((b == 0 && a > 0) || (b == 100 && a < 100)) {
                isPos = false;
            }

            // 결과 출력
            if (isPos) {
                System.out.printf("#%d Possible\n", tc);
            } else {
                System.out.printf("#%d Broken\n", tc);
            }
        }
    }
}
