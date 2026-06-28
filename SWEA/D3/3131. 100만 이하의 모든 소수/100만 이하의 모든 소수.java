import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 생성
        int[] d = new int[1000001];
        d[0] = 1;
        d[1] = 1;

        // 아리스토테네스의 체
        for (int i = 2; i <= 1000; i++) {
            if (d[i] == 0) {
                for (int j = i * i; j <= 1000000; j += i) {
                    d[j] = 1;
                }
            }
        }

        // 답 출력하기
        for (int i = 1; i <= 1000000; i++) {
            if (d[i] == 0) {
                System.out.printf("%d ", i);
            }
        }
    }
}
