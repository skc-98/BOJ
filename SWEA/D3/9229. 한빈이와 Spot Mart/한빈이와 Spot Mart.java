import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 과자 봉지의 수, 무게 합 제한
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 과자 봉지의 무게 입력
            int[] snacks = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            // 과자 두 봉지를 선택하는 모든 경우 확인
            int ans = -1;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 무게 제한을 넘지 않는 경우, 합이 더 크면 갱신
                    int sum = snacks[i] + snacks[j];
                    if (sum <= m) {
                        if (sum > ans) {
                            ans = sum;
                        }
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}