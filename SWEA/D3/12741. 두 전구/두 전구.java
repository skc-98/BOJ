import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 전구가 켜진 시간 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int e1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            // 전구가 켜진 시간 구하기
            int ans = Math.max(0, Math.min(e1, e2) - Math.max(s1, s2));

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}