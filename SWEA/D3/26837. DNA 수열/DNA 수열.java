import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            // 시작 위치 정하기
            int ans = 0;
            for (int i = 0; i < n; i++) {
                // 각 문자의 수 세기
                int[] d = new int[1001];

                // 끝 위치를 하나씩 늘리면서 확인
                for (int j = i; j < n; j++) {
                    d[s.charAt(j)]++;

                    // A랑 T, C랑 G 개수 맞는지 확인
                    if (d['A'] == d['T'] && d['C'] == d['G']) {
                        ans++;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("%d\n", ans);
        }
    }
}
