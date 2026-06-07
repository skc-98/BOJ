import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 요일 입력
            String s = br.readLine();

            // 답 구하기
            int ans = 0;
            if (s.equals("SUN")) {
                ans = 7;
            } else if (s.equals("MON")) {
                ans = 6;
            } else if (s.equals("TUE")) {
                ans = 5;
            } else if (s.equals("WED")) {
                ans = 4;
            } else if (s.equals("THU")) {
                ans = 3;
            } else if (s.equals("FRI")) {
                ans = 2;
            } else if (s.equals("SAT")) {
                ans = 1;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
