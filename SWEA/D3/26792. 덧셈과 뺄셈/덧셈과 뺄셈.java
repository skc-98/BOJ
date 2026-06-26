import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // A+B, A-B 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int plus = Integer.parseInt(st.nextToken());
            int minus = Integer.parseInt(st.nextToken());

            // 답 구하기
            int a = (plus + minus) / 2;
            int b = (plus - a);

            // 답 출력하기
            System.out.printf("%d %d\n", a, b);
        }
    }
}
