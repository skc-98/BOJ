import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 불러주는 숫자 입력
            String s = br.readLine();

            // 최종 글자 구하기
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                String ch = String.valueOf(s.charAt(i));
                if (ans.contains(ch)) {
                    ans = ans.replace(ch, "");
                } else {
                    ans += ch;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans.length());
        }
    }
}
