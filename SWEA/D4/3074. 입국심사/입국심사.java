import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 심사대의 수 n, 사람의 수 m
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            // 각 심사대에서 심사에 걸리는 시간, 최댓값
            long[] time = new long[n];
            long max = 0;

            // 각 심사대의 심사 시간 입력
            for (int i = 0; i < n; i++) {
                time[i] = Long.parseLong(br.readLine());
                max = Math.max(max, time[i]);
            }

            // 최소 시간 이분 탐색
            long left = 0;
            long right = max * m;
            long ans = right;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long count = 0;

                // 각 심사대에서 처리할 수 있는 사람의 수 계산
                for (int i = 0; i < n; i++) {
                    count += mid / time[i];
                    if (count >= m) {
                        break;
                    }
                }

                // 현재 시간 안에 모든 사람을 심사 가능
                if (count >= m) {
                    ans = mid;
                    right = mid - 1;
                }
                // 현재 시간으로 모든 사람 심사 불가
                else {
                    left = mid + 1;
                }
            }

            // 결과 출력
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}