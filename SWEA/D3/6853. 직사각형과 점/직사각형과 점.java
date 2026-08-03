import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 직사각형 좌표 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 점의 수 입력
            int n = Integer.parseInt(br.readLine());

            // 각 점 입력
            int a1 = 0, a2 = 0, a3 = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 점의 위치 카운트
                if (x1 < x && x < x2 && y1 < y && y < y2) {
                    a1++;
                } else if (x1 <= x && x <= x2 && y1 <= y && y <= y2) {
                    a2++;
                } else {
                    a3++;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d %d %d\n", tc, a1, a2, a3);
        }
    }
}