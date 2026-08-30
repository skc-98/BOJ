import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // n 입력
            int n = Integer.parseInt(br.readLine());

            // 산불 수열
            int[] d = new int[n + 2];
            d[0] = 1;
            d[1] = 1;

            // n번째 항까지 계산
            for (int i = 2; i <= n; i++) {
                int value = 1;
                while (true) {
                    boolean check = true;

                    // 등차수열을 이루는지 확인
                    for (int j = 1; j <= i / 2; j++) {
                        if (value - d[i - j] == d[i - j] - d[i - 2 * j]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        d[i] = value;
                        break;
                    }
                    value++;
                }
            }

            // 답 출력하기
            System.out.printf("%d\n", d[n]);
        }
    }
}