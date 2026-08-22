import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 학생과 조의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 학생 배치하기
            int[] d = new int[m];
            int rank = 1;
            for (int i = 0; i < n; i++) {
                // 짝수 번째 줄
                if (i % 2 == 0) {
                    for (int j = 0; j < m; j++) {
                        d[j] += rank++;
                    }
                }

                // 홀수 번째 줄
                else {
                    for (int j = m - 1; j >= 0; j--) {
                        d[j] += rank++;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d ", tc);
            for (int i = 0; i < m; i++) {
                System.out.printf("%d ", d[i]);
            }
            System.out.println();
        }
    }
}