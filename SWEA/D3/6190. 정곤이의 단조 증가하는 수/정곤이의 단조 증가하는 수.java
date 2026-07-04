import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 정수의 수
            int n = Integer.parseInt(br.readLine());

            // 각 정수 입력
            int[] d = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 모든 수의 조합 구하기
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    li.add(d[i] * d[j]);
                }
            }

            // 구한 수 중 가장 큰 단조 증가 수 구하기
            int ans = -1;
            for (int i = 0; i < li.size(); i++) {
                int temp = li.get(i);
                int pre = 10;
                boolean ok = true;

                while (temp > 0) {
                    int cur = temp % 10;
                    if (cur > pre) {
                        ok = false;
                        break;
                    }
                    pre = cur;
                    temp /= 10;
                }

                // 단조 증가하는 수는 최댓값 비교
                if (ok) {
                    ans = Math.max(ans, li.get(i));
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
