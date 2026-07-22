import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 명령의 수
            int n = Integer.parseInt(br.readLine());

            // 현재 속도와 총 이동거리
            int speed = 0;
            int dist = 0;

            // 명령 입력
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());

                // 명령에 따라 속도 계산
                if (command == 1) {
                    int value = Integer.parseInt(st.nextToken());
                    speed += value;
                } else if (command == 2) {
                    int value = Integer.parseInt(st.nextToken());
                    speed -= value;
                    if (speed < 0) {
                        speed = 0;
                    }
                }

                // 거리 계산
                dist += speed;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, dist);
        }
    }
}
