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
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            // 다 초로 바꾼다음 다시 계산
            int now = (hour * 24 * 60) + (min * 60) + (sec);
            int promise = (11 * 24 * 60) + (11 * 60) + 11;

            // 답 출력하기
            int ans = now - promise;
            if (ans < 0) {
                System.out.printf("#%d -1\n", tc);
            } else {
                System.out.printf("#%d %d\n", tc, now - promise);
            }
        }
    }
}