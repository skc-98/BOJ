import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 홀수 입력
            long n = Long.parseLong(br.readLine());

            // 규칙에 맞게 답 구하기
            long ans = (n / 2) * (n / 2);

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}