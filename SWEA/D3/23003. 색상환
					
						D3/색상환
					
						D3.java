import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 색상환
        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 색상 입력
            String s = br.readLine();
            String[] d = s.split(" ");
            String a = d[0];
            String b = d[1];

            // 색 차이값 구하기
            int aa = 0;
            int bb = 0;
            for (int i = 0; i < colors.length; i++) {
                if (colors[i].equals(a)) {
                    aa = i;
                }
                if (colors[i].equals(b)) {
                    bb = i;
                }
            }
            int diff = Math.abs(aa - bb);

            // 차잇값을 통해 답 출력하기
            if (diff == 0) {
                System.out.println("E");
            } else if (diff == 1 || diff == 5) {
                System.out.println("A");
            } else if (diff == 3) {
                System.out.println("C");
            } else {
                System.out.println("X");
            }
        }
    }
}
