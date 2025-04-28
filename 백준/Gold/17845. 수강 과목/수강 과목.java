import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] d = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            d[i][0] = Integer.parseInt(st.nextToken());
            d[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < k; i++) {
            int value = d[i][0];
            int time = d[i][1];
            
            for (int j = n; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + value);
            }
        }
        
        System.out.print(dp[n]);
    }
}
