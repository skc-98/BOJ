import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());

        // 각 테케의 답 구하기
        for (int tc = 1; tc <= tcn; tc++) {
            // 문자열 길이
            int n = Integer.parseInt(br.readLine());

            // 문자열 입력
            String s = br.readLine();

            // 반씩 나누고 비교
            boolean ans = true;
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(i + (n / 2))) {
                    ans = false;
                    break;
                }
            }

            // 길이 홀수면
            if (n % 2 == 1) ans = false;

            // 답 출력하기
            if (ans) {
                System.out.printf("#%d Yes\n", tc);
            } else {
                System.out.printf("#%d No\n", tc);
            }
        }
    }
}