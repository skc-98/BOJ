import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 테케의 답 구하기
        for (int tc = 1; tc <= 10; tc++) {
            // 계산식의 길이
            int n = Integer.parseInt(br.readLine());

            // 계산식
            String s = br.readLine();

            // 계산식 쪼개서 더하기
            int ans = 0;
            String[] d = s.split("\\+");
            for (int i = 0; i < d.length; i++) {
                ans += Integer.parseInt(d[i]);
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
