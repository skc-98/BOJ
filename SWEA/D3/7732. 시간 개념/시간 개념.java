import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 현재 시각과 약속 시간 입력
            String now = br.readLine();
            String prom = br.readLine();

            // 모두 초로 바꿔서 계산
            String[] nowTime = now.split(":");
            String[] promTime = prom.split(":");
            int nowSecond = Integer.parseInt(nowTime[0]) * 3600 + Integer.parseInt(nowTime[1]) * 60 + Integer.parseInt(nowTime[2]);
            int promSecond = Integer.parseInt(promTime[0]) * 3600 + Integer.parseInt(promTime[1]) * 60 + Integer.parseInt(promTime[2]);

            // 남은 시간 계산
            int resultSecond = promSecond - nowSecond;
            if (resultSecond < 0) {
                resultSecond += 24 * 60 * 60;
            }
            int hour = resultSecond / 3600;
            int minute = resultSecond % 3600 / 60;
            int second = resultSecond % 60;

            // 답 출력하기
            System.out.printf("#%d %02d:%02d:%02d%n", tc, hour, minute, second);
        }
    }
}