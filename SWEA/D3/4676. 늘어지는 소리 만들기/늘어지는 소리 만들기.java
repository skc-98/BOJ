import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 원래 문자열 입력
            String s = br.readLine();

            // 하이픈의 수
            int hype = Integer.parseInt(br.readLine());

            // 문자열 길이에 맞게 하이픈 배열 만들어두고 위치 카운트
            int[] d = new int[s.length() + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < hype; i++) {
                int h = Integer.parseInt(st.nextToken());
                d[h]++;
            }

            // 답 출력하기
            System.out.printf("#%d ", tc);
            for (int i = 0; i < s.length() + 1; i++) {
                if (d[i] != 0) {
                    for (int j = 0; j < d[i]; j++) {
                        System.out.print("-");
                    }
                }
                if (i != s.length()) {
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
