import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 원래 비트 입력
            String s = br.readLine();

            // 비트 변환하면서 카운트
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    ans++;
                    String after = s.substring(0, i + 1);
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) == '1') {
                            after += "0";
                        } else {
                            after += "1";
                        }
                    }
                    s = after;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
