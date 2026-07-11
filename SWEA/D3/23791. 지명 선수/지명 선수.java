import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 선수의 수
            int n = Integer.parseInt(br.readLine());

            // 각 팀 선호 선수 입력
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            // 정답 구하기
            char[] ans = new char[n + 1];
            int ai = 0, bi = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    while (ans[a[ai]] != 0) {
                        ai++;
                    }
                    ans[a[ai]] = 'A';
                } else {
                    while (ans[b[bi]] != 0) {
                        bi++;
                    }
                    ans[b[bi]] = 'B';
                }
            }

            // 답 출력하기
            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i]);
            }
            System.out.println();
        }
    }
}