import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 영화 제목의 수
            int n = Integer.parseInt(br.readLine());

            // 영화 제목 입력 받으면서 카운트
            int[] d = new int[200];
            for (int i = 0; i < n; i++) {
                // 영화 제목
                String s = br.readLine();
                d[s.charAt(0)]++;
            }

            // A~Z 까지 확인
            int ans = 0;
            for (int i = 'A'; i <= 'Z'; i++) {
                if (d[i] != 0) {
                    ans++;
                } else break;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}