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

            // 다이아 패턴 출력
            // 첫 번째 줄
            for (int j = 0; j < s.length(); j++) {
                System.out.print("..#.");
            }
            System.out.print(".");
            System.out.println();

            // 두 번째 줄
            for (int j = 0; j < s.length(); j++) {
                System.out.print(".#.#");
            }
            System.out.print(".");
            System.out.println();

            // 세 번째 줄
            for (int j = 0; j < s.length(); j++) {
                System.out.printf("#.%c.", s.charAt(j));
            }
            System.out.print("#");
            System.out.println();

            // 네 번째 줄
            for (int j = 0; j < s.length(); j++) {
                System.out.print(".#.#");
            }
            System.out.print(".");
            System.out.println();

            // 다섯 번째 줄
            for (int j = 0; j < s.length(); j++) {
                System.out.print("..#.");
            }
            System.out.print(".");
            System.out.println();
        }
    }
}
