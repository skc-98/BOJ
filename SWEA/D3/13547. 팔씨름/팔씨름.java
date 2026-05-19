import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 현재까지 진행한 경기 입력
            String s = br.readLine();

            // 아직 안한 경기 수
            int n = 15 - s.length();

            // 현재까지 이긴 수
            int win = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    win++;
                }
            }

            // 8승 이상인지 확인 후 답 출력
            int ans = n + win;
            if (ans >= 8) {
                System.out.printf("#%d YES\n", tc);
            } else {
                System.out.printf("#%d NO\n", tc);
            }
        }
    }
}
