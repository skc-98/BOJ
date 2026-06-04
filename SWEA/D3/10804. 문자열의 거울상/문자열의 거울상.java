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

            // 거울상 구하기
            String ans = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                char now = s.charAt(i);
                // 반대 알파벳으로 변환
                if (now == 'b') {
                    ans += 'd';
                } else if (now == 'd') {
                    ans += 'b';
                } else if (now == 'p') {
                    ans += 'q';
                } else if (now == 'q') {
                    ans += 'p';
                }
            }

            // 답 출력하기
            System.out.printf("#%d %s\n", tc, ans);
        }
    }
}
