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
            String s=br.readLine();

            // 각 방향의 개수 저장
            int[] count = new int[4];
            for (int i = 0; i < s.length(); i++) {
                // 현재 문자
                char c = s.charAt(i);
                if (c == 'N') {
                    count[0]++;
                } else if (c == 'S') {
                    count[1]++;
                } else if (c == 'E') {
                    count[2]++;
                } else {
                    count[3]++;
                }
            }

            // 이동 가능 여부 확인
            if ((count[0] == 0) != (count[1] == 0)) {
                System.out.println("No");
            } else if ((count[2] == 0) != (count[3] == 0)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}