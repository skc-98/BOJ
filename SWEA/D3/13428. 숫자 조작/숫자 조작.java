import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 정수 입력
            String n = br.readLine();

            // 최솟값, 최댓값 초기화
            int min = Integer.parseInt(n);
            int max = Integer.parseInt(n);
            char[] d = n.toCharArray();

            // 두 자리 선택
            for (int i = 0; i < d.length; i++) {
                for (int j = i + 1; j < d.length; j++) {
                    // 두 자리 교환
                    char temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;

                    // 맨 앞자리가 0이 아닌 경우만 확인
                    if (d[0] != '0') {
                        int num = Integer.parseInt(new String(d));
                        min = Math.min(min, num);
                        max = Math.max(max, num);
                    }

                    // 복구
                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, min, max);
        }
    }
}