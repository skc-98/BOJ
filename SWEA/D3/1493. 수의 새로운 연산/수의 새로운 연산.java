import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 두 정수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 수를 좌표로 변환 후 답 구하기
            int nx = 0, ny = 0, mx = 0, my = 0;
            int number = 1, i = 2;
            while (nx == 0 || mx == 0) {
                for (int j = 1; j < i; j++) {
                    int k = i - j;
                    if (number == n) {
                        nx = j;
                        ny = k;
                    }
                    if (number == m) {
                        mx = j;
                        my = k;
                    }
                    number++;
                }
                i++;
            }

            int x = nx + mx;
            int y = ny + my;
            number = 1;
            i = 2;
            int ans = 0;
            while (ans == 0) {
                for (int j = 1; j < i; j++) {
                    int k = i - j;
                    if (j == x && k == y) {
                        ans = number;
                        break;
                    }
                    number++;
                }
                i++;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}