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

            // 각 첫 글자 대문자로
            String ans = "";
            ans += Character.toUpperCase(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == ' ') {
                    ans += Character.toUpperCase(s.charAt(i));
                }
            }

            // 답 출력하기
            System.out.printf("#%d %s\n", tc, ans);
        }
    }
}