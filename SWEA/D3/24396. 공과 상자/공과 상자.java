import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 검은공, 흰공, 검은 점수, 흰 점수, 반대 점수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 답 구하기
            int ans = b * x + w * y;
            if (x + y < 2 * z) {
                int pair = Math.min(b, w);
                ans += pair * (2 * z - x - y);
            }

            // 답 출력하기
            System.out.printf("%d\n", ans);
        }
    }
}
