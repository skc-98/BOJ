import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 상태 입력
            String s = br.readLine();

            // 최소 공의 수 세기
            int ans = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                String isBall = s.substring(i, i + 2);
                if (isBall.equals("(|") || isBall.equals("|)") || isBall.equals("()")) {
                    ans++;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
