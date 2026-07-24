import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 단어의 수
            int n = Integer.parseInt(br.readLine());

            // 단어 입력
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            // 단어를 선택하는 모든 경우
            int ans = 0;
            for (int mask = 0; mask < (1 << n); mask++) {
                boolean[] alphabet = new boolean[26];

                for (int i = 0; i < n; i++) {
                    // i번째 단어가 선택된 경우
                    if ((mask & (1 << i)) != 0) {
                        for (int j = 0; j < words[i].length(); j++) {
                            char c = words[i].charAt(j);

                            if (c >= 'a' && c <= 'z') {
                                alphabet[c - 'a'] = true;
                            }
                        }
                    }
                }

                boolean possible = true;

                // a부터 z까지 모두 포함됐는지 확인
                for (int i = 0; i < 26; i++) {
                    if (!alphabet[i]) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    ans++;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}