import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 문자열 입력
            String s = br.readLine();

            // 문자열 카운팅
            char[] d = new char[100];
            for (int i = 0; i < s.length(); i++) {
                d[s.charAt(i)]++;
            }

            // 반반여부 확인
            int count = 0;
            for (int i = 'A'; i <= 'Z'; i++) {
                if (d[i] == 2) count++;
            }

            // 답 출력하기
            if (count == 2) {
                System.out.printf("#%d Yes\n", tc);
            } else {
                System.out.printf("#%d No\n", tc);
            }
        }
    }
}
