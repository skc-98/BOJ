import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());

        // 각 테케의 답 구하기
        for (int tc = 1; tc <= tcn; tc++) {
            // 문자열 입력
            String s = br.readLine();

            // 패턴 마디 길이 구하기
            int ans = 0;
            for (int i = 1; i <= 10; i++) {
                // 패턴 길이가 최대 10이니까 패턴 확인
                String pattern = s.substring(0, i);
                boolean isP = true;

                // 문자열 검사
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != pattern.charAt(j % i)) {
                        isP = false;
                        break;
                    }
                }

                // 패턴 찾았을 시
                if (isP) {
                    ans = i;
                    break;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
