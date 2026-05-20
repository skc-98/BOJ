import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 앉아있는 사람의 수
            int n = Integer.parseInt(br.readLine());

            // 사람마다 빈 좌석 입력
            int[] d = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(d);

            // 최소 좌석의 수 구하기, 맨 처음 공백으로 시작
            int ans = d[0];
            for (int i = 0; i < n; i++) {
                // 사람이 앉은 좌석 더하기
                ans++;

                // 끝 사람 처리
                if (i == n - 1) {
                    ans += d[i];
                    break;
                }

                // 오른쪽 빈칸 더하기
                ans += Math.max(d[i], d[i + 1]);
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
