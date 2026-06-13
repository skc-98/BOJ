import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 데미지, 레벨, 타격 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dmg = Integer.parseInt(st.nextToken());
            int lv = Integer.parseInt(st.nextToken());
            int hit = Integer.parseInt(st.nextToken());

            // 총 데미지 구하기
            int ans = 0;
            for (int n = 0; n < hit; n++) {
                ans += dmg;
                ans += dmg * n * lv / 100;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
