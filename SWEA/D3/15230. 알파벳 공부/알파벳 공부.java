import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 알파벳 입력
            String s = br.readLine();

            // 올바른거 개수 세기
            int ans = 0;
            char now = 'a';
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == now) {
                    ans++;
                } else break;
                now++;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}