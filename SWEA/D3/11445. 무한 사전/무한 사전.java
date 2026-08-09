import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 두 단어 입력
            String word1 = br.readLine().trim();
            String word2 = br.readLine().trim();

            // 바로 다음에 오는 단어는 a를 붙임
            String nextWord = word1 + "a";

            // 바로 다음 단어라면 사이에 다른 단어가 없음
            if (word2.equals(nextWord)) {
                System.out.printf("#%d N\n", tc);
            }
            // 그 외에는 다른 단어가 존재
            else {
                System.out.printf("#%d Y\n", tc);
            }
        }
    }
}
