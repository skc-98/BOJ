import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 화살의 개수
            int n = Integer.parseInt(br.readLine());

            // 화살 입력 받으면서 점수 구하기
            int ans = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 화살의 위치
                int location = x * x + y * y;

                // 위치 찾기
                for (int j = 10; j >= 1; j--) {
                    int radius = 20 * (11 - j);
                    if (location <= radius * radius) {
                        ans += j;
                        break;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}