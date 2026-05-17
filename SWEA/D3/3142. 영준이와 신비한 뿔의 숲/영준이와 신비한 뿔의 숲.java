import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 뿔의 수랑 동물의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 유니콘의 수와 트윈혼의 수 구하기
            int twin = n - m;
            int uni = m - twin;

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, uni, twin);
        }
    }
}
