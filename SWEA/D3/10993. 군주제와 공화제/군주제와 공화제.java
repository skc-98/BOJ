import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    static int[] x, y, s;
    static int[] follow;

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 도시의 수
            n = Integer.parseInt(br.readLine());

            // 각 도시 정보 입력
            x = new int[n];
            y = new int[n];
            s = new int[n];
            follow = new int[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                s[i] = Integer.parseInt(st.nextToken());
            }

            // 각 도시가 직접 따르는 도시 계산
            for (int i = 0; i < n; i++) {
                follow[i] = findRuler(i);
            }

            // 결과 출력
            System.out.print("#" + tc + " ");
            for (int i = 0; i < n; i++) {
                int result = findFinal(i);
                if (result == -1) {
                    System.out.print("K ");
                } else if (result == -2) {
                    System.out.print("D ");
                } else {
                    System.out.print((result + 1) + " ");
                }
            }
            System.out.println();
        }
    }

    // 해당 도시를 가장 강하게 위협하는 도시 찾기
    static int findRuler(int city) {
        int maxCity = -1;
        long maxPower = 0;
        long maxDistance = 1;
        boolean same = false;
        for (int j = 0; j < n; j++) {
            if (city == j) continue;
            long dx = x[city] - x[j];
            long dy = y[city] - y[j];
            long distance = dx * dx + dy * dy;

            // 도시 j가 city를 위협하는지 확인
            if ((long) s[j] > (long) s[city] * distance) {
                // 처음 발견한 위협 도시
                if (maxCity == -1) {
                    maxCity = j;
                    maxPower = s[j];
                    maxDistance = distance;
                    same = false;
                }

                // 기존 최대 영향력보다 큰 경우
                else if ((long) s[j] * maxDistance > maxPower * distance) {
                    maxCity = j;
                    maxPower = s[j];
                    maxDistance = distance;
                    same = false;
                }

                // 최대 영향력이 같은 경우
                else if ((long) s[j] * maxDistance == maxPower * distance) {
                    same = true;
                }
            }
        }

        // 위협하는 도시가 없음
        if (maxCity == -1) {
            return -1;
        }

        // 최대 영향력 도시가 여러 개
        if (same) {
            return -2;
        }

        // 최대 영향력 도시가 하나
        return maxCity;
    }

    // 최종적으로 따르는 도시 또는 체제 찾기
    static int findFinal(int city) {
        int now = city;
        while (follow[now] >= 0) {
            now = follow[now];
        }

        // 자기 자신이 K 또는 D인 경우
        if (now == city) {
            return follow[now];
        }

        // 다른 도시의 체제를 따르는 경우
        return now;
    }
}