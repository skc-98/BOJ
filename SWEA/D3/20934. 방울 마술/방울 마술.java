import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 방울 위치, 방울이 울린 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            // 현재 방울의 위치
            int ans = s.indexOf('o');

            // 방울이 한 번 울릴 때마다 위치 이동
            for (int i = 0; i < n; i++) {
                // 왼쪽 또는 오른쪽에 있으면 가운데로 이동
                if (ans == 0 || ans == 2) {
                    ans = 1;
                }
                // 가운데에 있으면 왼쪽 선택
                else {
                    ans = 0;
                }
            }
            
            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
