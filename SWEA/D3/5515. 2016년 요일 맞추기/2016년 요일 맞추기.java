import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 날짜 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 각 월마다 일 수
            int[] days = {
                    31, 29, 31, 30, 31,
                    30, 31, 31, 30, 31, 30, 31
            };

            // 날짜 나머지로 요일 구하기
            int count = d - 1;
            for (int i = 0; i < m - 1; i++) {
                count += days[i];
            }

            // 2016년 1월 1일이 금요일이니까 4 더하기
            int ans = (4 + count) % 7;

            // 나머지로 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}