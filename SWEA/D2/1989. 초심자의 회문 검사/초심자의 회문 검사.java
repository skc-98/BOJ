import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 펠린드롬 여부 확인할 문자열
            String s = br.readLine();

            // 펠린드롬 체크
            boolean isPal = true;
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    isPal = false;
                    break;
                }

                left++;
                right--;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, isPal ? 1 : 0);
        }
    }
}