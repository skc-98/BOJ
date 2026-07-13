import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 각 상자의 사탕 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 뒤에서부터 조건에 맞게 사탕 수 조정
            int count = 0;
            if (b >= c) {
                count += b - c + 1;
                b = c - 1;
            }
            if (a >= b) {
                count += a - b + 1;
                a = b - 1;
            }

            // 모든 상자에 사탕이 1개 이상 있어야 함
            if (a < 1 || b < 1) {
                count = -1;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, count);
        }
    }
}
