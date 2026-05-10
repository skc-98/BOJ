import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 직사각형 세 변의 길이 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 변이 네개니까 그냥 조건문
            if (a == b) {
                System.out.printf("#%d %d\n", tc, c);
            } else if (b == c) {
                System.out.printf("#%d %d\n", tc, a);
            } else if (a == c) {
                System.out.printf("#%d %d\n", tc, b);
            }
        }
    }
}
