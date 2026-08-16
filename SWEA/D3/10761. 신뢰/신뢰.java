import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 눌러야 하는 버튼의 수, 버튼
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // 현재 위치랑 마지막 버튼 시간
            int oLoc = 1, bLoc = 1;
            int oTime = 0, bTime = 0;

            // 전체 소요 시간
            int totalTime = 0;
            for (int i = 0; i < n; i++) {
                // 오렌지랑 블루의 버튼 입력
                String robot = st.nextToken();
                int button = Integer.parseInt(st.nextToken());

                // 오렌지의 경우
                if (robot.equals("O")) {
                    // 오렌지가 이동하는 시간
                    int moveTime = Math.abs(oLoc - button);
                    oTime = Math.max(totalTime, oTime + moveTime) + 1;

                    // 오렌지 위치와 전체 시간 갱신
                    oLoc = button;
                    totalTime = oTime;
                }
                // 블루의 경우
                else {
                    // 블루가 이전 위치에서 현재 버튼까지 이동하는 시간
                    int moveTime = Math.abs(bLoc - button);
                    bTime = Math.max(totalTime, bTime + moveTime) + 1;

                    // 블루 위치와 전체 시간 갱신
                    bLoc = button;
                    totalTime = bTime;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, totalTime);
        }
    }
}