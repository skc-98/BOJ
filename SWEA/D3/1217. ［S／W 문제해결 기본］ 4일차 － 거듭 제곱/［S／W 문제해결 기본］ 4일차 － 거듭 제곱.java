import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 수
        for (int tc = 1; tc <= 10; tc++) {
            // 테스트 케이스의 번호
            int tcn = sc.nextInt();

            // 숫자 입력
            int n = sc.nextInt();
            int m = sc.nextInt();

            // 답 구하기
            int ans = 1;
            for (int i = 0; i < m; i++) {
                ans *= n;
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}