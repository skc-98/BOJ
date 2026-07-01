import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 사람, 시간, 붕어빵 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 각 사람이 도착하는 시간
            int[] d = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(d);

            // 답 구하기
            String ans = "Possible";
            for (int i = 0; i < n; i++) {
                int made = (d[i] / m) * k;
                int need = i + 1;

                if (made < need) {
                    ans = "Impossible";
                    break;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %s\n", tc, ans);
        }
    }
}
