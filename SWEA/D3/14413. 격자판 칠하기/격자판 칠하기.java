import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 격자판 크기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 격자판 입력
            char[][] d = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    d[i][j] = s.charAt(j);
                }
            }

            // 첫 칸에 따라 다르게
            boolean case1 = true;
            boolean case2 = true;

            // 두 가지 격자 패턴 확인
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 아무 색이나 가능
                    if (d[i][j] == '?') continue;

                    // 첫 칸이 #인 경우
                    char c1;
                    if ((i + j) % 2 == 0) {
                        c1 = '#';
                    } else {
                        c1 = '.';
                    }
                    if (d[i][j] != c1) {
                        case1 = false;
                    }

                    // 첫 칸이 .인 경우
                    char c2;
                    if ((i + j) % 2 == 0) {
                        c2 = '.';
                    } else {
                        c2 = '#';
                    }
                    if (d[i][j] != c2) {
                        case2 = false;
                    }
                }
            }

            // 둘 중 하나라도 가능하면 possible
            if (case1 || case2) {
                System.out.printf("#%d possible\n", tc);
            } else {
                System.out.printf("#%d impossible\n", tc);
            }
        }
    }
}