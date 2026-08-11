import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 각도 입력
            int n = Integer.parseInt(br.readLine());

            // 현재 시각 구하기
            int time = n * 2;
            int hour = time / 60;
            int minute = time % 60;
            if (hour > 24) hour -= 24;

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, hour, minute);
        }
    }
}