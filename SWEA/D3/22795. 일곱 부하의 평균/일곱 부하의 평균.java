import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 여섯 부하의 키 입력하고 다 더하기, 최대 키 찾기
            int sum = 0;
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                int height = Integer.parseInt(st.nextToken());
                sum += height;
                max = Math.max(max, height);
            }

            // 가장 큰 키보다 1 큰 값부터 확인
            int x = max + 1;

            // 일곱 명의 키 평균이 정수가 될 때까지 1씩 증가
            while ((sum + x) % 7 != 0) {
                x++;
            }

            // 가능한 가장 작은 키 출력
            System.out.println(x);
        }
    }
}