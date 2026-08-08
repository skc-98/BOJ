import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 기차 사이 거리, 각 기차 속력, 파리 속력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 두 기차가 만날 때까지 걸리는 시간
            double time = (double) n / (a + b);

            // 파리가 이동한 거리
            double result = c * time;

            // 결과 출력
            System.out.printf("#%d %.10f\n", tc, result);
        }
    }
}