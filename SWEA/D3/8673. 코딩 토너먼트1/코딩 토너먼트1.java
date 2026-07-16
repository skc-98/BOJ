import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 라운드 수
            int n = Integer.parseInt(br.readLine());

            // 코딩 실력 입력
            int size = (int) Math.pow(2, n);
            int[] d = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 라운드 진행
            int ans = 0;
            while (size > 1) {
                for (int i = 0; i < size / 2; i++) {
                    int a = d[i * 2];
                    int b = d[i * 2 + 1];
                    ans += Math.abs(a - b);
                    d[i] = Math.max(a, b);
                }
                size /= 2;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
