import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 건조 더미의 수
            int n = Integer.parseInt(br.readLine());

            // 건초 입력, 평균 구하기
            int[] d = new int[n];
            int sum = 0, avg = 0;
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(br.readLine());
                sum += d[i];
            }
            avg = sum / n;

            // 각 건초더미에서 평균 기준으로 더하고 빼기
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (d[i] > avg) {
                    ans += d[i] - avg;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}