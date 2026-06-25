import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 두 문자열 입력
            String s = br.readLine();
            String[] words = s.split(" ");
            String s1 = words[0];
            String s2 = words[1];

            // 알파벳 별 구멍 수
            String hole0 = "CEFGHIJKLMNSTUVWXYZ";
            String hole1 = "ADOPQR";
            String hole2 = "B";

            // 각 문자열의 자리 비교로 답 구하기
            boolean ans = true;
            if (s1.length() != s2.length()) {
                ans = false;
            } else {

                for (int i = 0; i < s1.length(); i++) {
                    // 현재 자리 문자 비교
                    if (hole0.contains(String.valueOf(s1.charAt(i))) &&
                            hole0.contains(String.valueOf(s2.charAt(i)))) continue;

                    if (hole1.contains(String.valueOf(s1.charAt(i))) &&
                            hole1.contains(String.valueOf(s2.charAt(i)))) continue;

                    if (hole2.contains(String.valueOf(s1.charAt(i))) &&
                            hole2.contains(String.valueOf(s2.charAt(i)))) continue;

                    // 다를 경우 정지
                    ans = false;
                    break;
                }
            }

            // 답 출력하기
            if (!ans) {
                System.out.printf("#%d DIFF\n", tc);
            } else {
                System.out.printf("#%d SAME\n", tc);
            }
        }
    }
}
