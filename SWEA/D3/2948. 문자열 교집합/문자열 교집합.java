import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 집합 원소의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 문자열 집합 입력
            st = new StringTokenizer(br.readLine());
            HashSet<String> d1 = new HashSet<>(n1 * 2);
            for (int i = 0; i < n1; i++) {
                d1.add(st.nextToken());
            }

            // 두번째 집합 받으면서 공통 원소 수 세기
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n2; i++) {
                String now = st.nextToken();
                if (d1.contains(now)) {
                    ans++;
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}