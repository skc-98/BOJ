import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 통나무 길이
            int n = Integer.parseInt(br.readLine());

            // 자르는 횟수가 n-1이니까 홀짝 여부로 답 결정
            if (n % 2 == 0) {
                System.out.printf("#%d Alice\n", tc);
            } else {
                System.out.printf("#%d Bob\n", tc);
            }
        }
    }
}
