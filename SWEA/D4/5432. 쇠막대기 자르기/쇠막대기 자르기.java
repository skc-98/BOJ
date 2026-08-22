import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 쇠막대기 배치 입력
            String s = br.readLine();

            // 쇠막대기 조각 구하기
            int ans = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                // 여는 괄호인 경우
                if (s.charAt(i) == '(') {
                    stack.push('(');
                }

                // 닫는 괄호인 경우
                else {
                    // 괄호 하나 제거
                    stack.pop();

                    // 직전 문자가 '('라면 레이저
                    if (s.charAt(i - 1) == '(') {
                        ans += stack.size();
                    }

                    // 직전 문자가 ')'라면 쇠막대기의 끝
                    else {
                        ans++;
                    }
                }
            }

            // 결과 출력
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}