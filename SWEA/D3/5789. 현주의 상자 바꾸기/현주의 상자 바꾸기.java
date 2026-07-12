import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 상자의 수, 상자 변경 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 초기 세팅
            int[] d = new int[n + 1];

            // 상자 바꾸기
            for (int i = 1; i <= q; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                for (int j = from; j <= to; j++) {
                    d[j] = i;
                }
            }

            // 답 출력하기
            System.out.printf("#%d ", tc);
            for (int i = 1; i <= n; i++) {
                System.out.printf("%d ", d[i]);
            }
            System.out.println();
        }
    }
}