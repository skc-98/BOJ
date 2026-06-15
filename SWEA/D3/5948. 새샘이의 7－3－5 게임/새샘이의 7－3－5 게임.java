import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 7개의 숫자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] d = new int[7];
            for (int i = 0; i < 7; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            // 모든 조합 뽑기
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 7; j++) {
                    for (int k = j + 1; k < 7; k++) {
                        set.add(d[i] + d[j] + d[k]);
                    }
                }
            }

            // 정렬
            List<Integer> li = new ArrayList<>(set);
            Collections.sort(li, Collections.reverseOrder());

            // 답 출력하기
            int ans = li.get(4);
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
