import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // SEM력 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 가장 빠른 연도 탐색
            int ans = 1;
            for (int i = 1; ; i++) {
                if ((i - s) % 365 == 0 && (i - e) % 24 == 0 && (i - m) % 29 == 0) {
                    ans = i;
                    break;
                }
            }

            // 결과 출력
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}