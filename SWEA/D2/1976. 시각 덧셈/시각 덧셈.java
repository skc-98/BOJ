import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 시간 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour1 = Integer.parseInt(st.nextToken());
            int minute1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int minute2 = Integer.parseInt(st.nextToken());

            // 더하기
            int hour = hour1 + hour2;
            int min = minute1 + minute2;

            // 시간 정리
            if (min >= 60) {
                hour += (min / 60);
                min %= 60;
            }
            if (hour >= 12) {
                hour %= 12;
            }
            if (hour == 0) hour += 12;

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, hour, min);
        }
    }
}