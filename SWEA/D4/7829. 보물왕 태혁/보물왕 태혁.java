import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 약수의 수
            int n = Integer.parseInt(br.readLine());

            // 약수 입력
            int[] d = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(d);

            // 원래 수 구하기
            int ans = 1;
            ans *= d[0];
            ans *= d[n - 1];

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
