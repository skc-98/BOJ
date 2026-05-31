import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());

        // 369 시작
        for (int i = 1; i <= n; i++) {
            // 각 숫자 문자열로 변환
            String now = String.valueOf(i);

            // 해당 되는 경우
            int count = 0;
            for (int j = 0; j < now.length(); j++) {
                if (now.charAt(j) == '3' || now.charAt(j) == '6' || now.charAt(j) == '9') {
                    count++;
                }
            }
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
                continue;
            }

            // 해당 안되면
            System.out.printf("%s ", now);
        }
    }
}
