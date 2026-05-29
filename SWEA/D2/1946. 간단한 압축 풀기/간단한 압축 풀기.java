import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 압축된 수
            int n = Integer.parseInt(br.readLine());

            // 압축 풀기
            String ans = "";
            for (int i = 0; i < n; i++) {
                // 압축된 문자와 숫자 입력
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int times = Integer.parseInt(st.nextToken());

                // 압축 풀어서 한 문자열로 더하기
                for (int j = 0; j < times; j++) {
                    ans += s;
                }
            }

            // 답 출력하기
            System.out.printf("#%d\n", tc);
            for (int i = 0; i < ans.length(); i++) {
                if (i % 10 == 0 && i != 0) System.out.println();
                System.out.print(ans.charAt(i));
            }
            System.out.println();
        }
    }
}