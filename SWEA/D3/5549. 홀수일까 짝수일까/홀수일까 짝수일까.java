import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 판별할 수 입력
            String n = br.readLine();

            // 마지막 수만 알면 됨
            char last = n.charAt(n.length() - 1);

            // 홀수 짝수 판별하기
            if ((last - '0') % 2 == 0) {
                System.out.printf("#%d Even\n", tc);
            } else {
                System.out.printf("#%d Odd\n", tc);
            }
        }
    }
}
