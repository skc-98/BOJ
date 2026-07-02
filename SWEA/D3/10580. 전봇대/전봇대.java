import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 전선의 개수
            int n = Integer.parseInt(br.readLine());

            // 전선이 걸린 위치 입력
            int[] from = new int[n];
            int[] to = new int[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                from[i] = Integer.parseInt(st.nextToken());
                to[i] = Integer.parseInt(st.nextToken());
            }

            // 교차점 구하기
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((from[i] < from[j] && to[i] > to[j]) || (from[i] > from[j] && to[i] < to[j])) {
                        ans++;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
