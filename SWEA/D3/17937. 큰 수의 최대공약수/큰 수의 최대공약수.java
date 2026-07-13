import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 두 숫자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            // 문자열 비교해서 같으면 s1 아니면 1 출력
            if (s1.equals(s2)) {
                System.out.println("#" + tc + " " + s1);
            } else {
                System.out.println("#" + tc + " 1");
            }
        }
    }
}
