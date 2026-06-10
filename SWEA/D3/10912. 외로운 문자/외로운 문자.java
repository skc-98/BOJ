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

            // 문자열 배열 생성
            char[] d = new char[500];

            // 문자열 카운트
            for (int i = 0; i < s.length(); i++) {
                d[s.charAt(i)]++;
            }

            // 홀수인 문자열 세기, 남는거 더하기
            String ans = "";
            for (int i = 'a'; i <= 'z'; i++) {
                if (d[i] % 2 != 0) {
                    ans += (char) i;
                }
            }

            // 답 출력하기
            if (ans.equals("")) {
                System.out.printf("#%d Good\n", tc);
            } else {
                System.out.printf("#%d %s\n", tc, ans);
            }
        }
    }
}