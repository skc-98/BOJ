import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 수업 일수, 일주일 수업 일정 배열, 한 주 수업 수
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[7];
            int classCount = 0;

            // 수업 일정 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                d[i] = Integer.parseInt(st.nextToken());
                if (d[i] == 1) {
                    classCount++;
                }
            }

            // 최소 체류 일수 구하기
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) {
                if (d[i] == 0) {
                    continue;
                }

                // 남은 수업 일수, 체류 일수
                int remain = n;
                int days = 0;

                // 일주일 단위로 먼저 계산
                if (remain > classCount) {
                    int fullWeek = (remain - 1) / classCount;
                    remain -= fullWeek * classCount;
                    days += fullWeek * 7;
                }

                // 남은 수업을 들을 때까지 하루씩 진행
                int day = i;
                while (remain > 0) {
                    days++;
                    if (d[day] == 1) {
                        remain--;
                    }
                    day++;
                    if (day == 7) {
                        day = 0;
                    }
                }

                // 최소 체류 일수 갱신
                if (days < ans) {
                    ans = days;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}