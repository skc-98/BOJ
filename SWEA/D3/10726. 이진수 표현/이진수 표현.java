import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // n과 m 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // m개의 비트가 이진수인지 확인
            boolean isBinary = false;
            int p = (int) Math.pow(2, n);
            if (m % p == p - 1) {
                isBinary = true;
            }

            // 답 출력하기
            if (isBinary) {
                System.out.printf("#%d ON\n", tc);
            } else {
                System.out.printf("#%d OFF\n", tc);
            }
        }
    }
}