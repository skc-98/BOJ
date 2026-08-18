import java.util.*;
import java.io.*;

public class Solution {
    // 전역 변수 선언부
    static boolean[] isPrime = new boolean[1000];

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수 판별 배열 생성
        makePrime();

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 홀수 입력
            int n = Integer.parseInt(br.readLine());

            // 완전 탐색 돌리기
            int count = 0;
            for (int x = 2; x <= n; x++) {
                if (!isPrime[x]) continue;
                for (int y = x; y <= n; y++) {
                    if (!isPrime[y]) continue;
                    int z = n - x - y;
                    if (z < y) break;
                    if (z >= 2 && isPrime[z]) {
                        count++;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d\n", tc, count);
        }
    }

    // 에라토스테네스의 체
    static void makePrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < 1000; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < 1000; j += i) {
                isPrime[j] = false;
            }
        }
    }
}
