import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 층 번호
            long n = Long.parseLong(br.readLine());

            // 가장 왼쪽, 오른쪽 숫자 구하기
            long left = 2 * (n - 1) * (n - 1) + 1;
            long right = 2 * n * n - 1;

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, left, right);
        }
    }
}