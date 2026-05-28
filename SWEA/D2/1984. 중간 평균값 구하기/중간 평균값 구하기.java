import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 10개의 수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] d = new int[10];
            for (int i = 0; i < 10; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(d);

            // 제일 큰 수, 제일 작은 수 빼고 평균 구하기
            int sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += d[i];
            }
            int ans = (int) Math.round(sum / 8.0);

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
