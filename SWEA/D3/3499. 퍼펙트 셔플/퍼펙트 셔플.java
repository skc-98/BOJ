import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 카드 수 입력
            int n = Integer.parseInt(br.readLine());

            // 카드 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] d = new String[n];
            for (int i = 0; i < n; i++) {
                d[i] = st.nextToken();
            }

            // 앞쪽 덱과 뒤쪽 덱을 번갈아 출력
            System.out.print("#" + tc + " ");
            int mid = (n + 1) / 2;
            for (int i = 0; i < mid; i++) {
                System.out.print(d[i] + " ");

                // 뒤쪽 덱에 카드가 남아있는 경우 출력
                if (mid + i < n) {
                    System.out.print(d[mid + i] + " ");
                }
            }
            System.out.println();
        }
    }
}