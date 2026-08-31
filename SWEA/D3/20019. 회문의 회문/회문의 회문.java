import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 문자열 입력
            String s = br.readLine();

            // 전체 문자열 회문 확인
            boolean check = true;
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }

            // 앞쪽 절반 회문 확인
            for (int i = 0; i < (s.length() - 1) / 4 && check; i++) {
                if (s.charAt(i) != s.charAt((s.length() - 1) / 2 - 1 - i)) {
                    check = false;
                    break;
                }
            }

            // 결과 출력
            if (check) {
                System.out.printf("#%d YES\n", tc);
            } else {
                System.out.printf("#%d NO\n", tc);
            }
        }
    }
}