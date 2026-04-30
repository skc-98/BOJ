import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 만큼
        int tcn=Integer.parseInt(br.readLine());
        for(int tc=1; tc<=tcn; tc++){
            // 점의 수
            int n = Integer.parseInt(br.readLine());

            // 각 점의 x랑 y
            int[] x = new int[n];	
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }

            // 최대 넓이의 2배
            int ans = 0;
            for (int i = 0; i < n; i++) {
                // 최대 가로, 세로
                int maxWidth = 0;
                int maxHeight = 0;
                for (int j = 0; j < n; j++) {
                    // 같은 점 건너 뛰기
                    if (i == j) {
                        continue;
                    }

                    // y가 같으면 평행
                    if (y[i] == y[j]) {
                        maxWidth = Math.max(maxWidth, Math.abs(x[i] - x[j]));
                    }

                    // x가 같으면 평행
                    if (x[i] == x[j]) {
                        maxHeight = Math.max(maxHeight, Math.abs(y[i] - y[j]));
                    }
                }
                ans = Math.max(ans, maxWidth * maxHeight);
            }

            // 답 출력하기
            System.out.println(ans);
        }
	}
}