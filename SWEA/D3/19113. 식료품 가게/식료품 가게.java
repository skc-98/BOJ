import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 상점 품목의 수
            int n = Integer.parseInt(br.readLine());

            // 2n개의 정수 입력
            long[] price = new long[2 * n];
            boolean[] used = new boolean[2 * n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * n; i++) {
                price[i] = Long.parseLong(st.nextToken());
            }

            // 테케 번호 출력
            System.out.print("#" + tc);

            // 작은 값부터 확인
            int count = 0;
            for (int i = 0; i < 2 * n; i++) {
                // 이미 사용한 가격표 건너 뛰기
                if (used[i]) continue;

                // 가장 작은 미사용 값은 무조건 할인가
                long sale = price[i];

                // 할인가에 해당하는 정상가
                long original = sale * 4 / 3;

                // 현재 값을 할인가로 사용 처리
                used[i] = true;

                // 할인가 출력
                System.out.print(" " + sale);

                // 찾은 할인가 개수 증가
                count++;

                // 정상가를 찾아서 사용 처리
                for (int j = i + 1; j < 2 * n; j++) {
                    if (!used[j] && price[j] == original) {
                        used[j] = true;
                        break;
                    }
                }

                // 할인가를 모두 찾았으면 종료
                if (count == n) break;
            }
            System.out.println();
        }
    }
}