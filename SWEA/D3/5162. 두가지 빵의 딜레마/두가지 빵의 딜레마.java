import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 빵 가격과 가진 돈 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            // 싼 빵 선택
            int ans = 0;
            if (a > b) {
                ans = money / b;
            } else {
                ans = money / a;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}