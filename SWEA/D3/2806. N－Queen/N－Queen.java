import java.io.*;

public class Solution {
    // 전역 변수 선언부
    static int n;
    static int ans;
    static int[] d;

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 보드 크기
            n = Integer.parseInt(br.readLine());

            // 백트래킹 시작
            d = new int[n];
            ans = 0;
            backTracking(0);

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    // 백트래킹
    static void backTracking(int row) {
        if (row == n) {
            ans++;
            return;
        }

        // 현재 행의 모든 열 탐색
        for (int i = 0; i < n; i++) {
            // 충돌 검사
            boolean possible = true;
            for (int j = 0; j < row; j++) {
                if (d[j] == i || Math.abs(row - j) == Math.abs(i - d[j])) {
                    possible = false;
                    break;
                }
            }

            // 배치 가능한 경우 다음 행 탐색
            if (possible) {
                d[row] = i;
                backTracking(row + 1);
            }
        }
    }
}