import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 세 자연수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 최댓값의 위치에 따라 조건을 만족하는 세 정수 출력
            if (a == b && b == c) {
                System.out.printf("%d %d %d\n", a, b, c);
            } else if (a == b && a > c) {
                System.out.printf("%d %d %d\n", c, a, c);
            } else if (b == c && b > a) {
                System.out.printf("%d %d %d\n", a, a, b);
            } else if (a == c && a > b) {
                System.out.printf("%d %d %d\n", a, b, b);
            } else {
                System.out.println("-1 -1 -1");
            }
        }
    }
}