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

            // 방문 배열, 답
            int[] visit = new int[s.length()];
            String ans = "yes";

            // 각 숫자가 0번 또는 정확히 2번 등장하는지 확인
            int[] count = new int[10];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - '0']++;
            }

            for (int i = 0; i < 10; i++) {
                // 등장 횟수가 1번이거나 3번 이상이면 조건 불만족
                if (count[i] != 0 && count[i] != 2) {
                    ans = "no";
                    break;
                }
            }

            // 조건 확인
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);

                // 이미 확인한 문자는 넘어가기
                if (visit[i] == 0) {
                    int len = 0;
                    boolean find = false;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) == now) {
                            // 숫자로 변환
                            int number = now - '0';

                            // 숫자로 바꾼 거랑 length가 같다면 종료
                            if (number == len) {
                                visit[i] = 1;
                                visit[j] = 1;
                                find = true;
                            } else {
                                ans = "no";
                            }
                            break;
                        }
                        len++;
                    }

                    // 같은 숫자를 찾지 못한 경우
                    if (!find) {
                        ans = "no";
                    }

                    // 조건을 만족하지 않으면 더 확인할 필요 없음
                    if (ans.equals("no")) {
                        break;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("%s\n", ans);
        }
    }
}