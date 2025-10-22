import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 배열에 값 채우기
        int[] d=new int[n+1];
        Arrays.fill(d, 1);
        for(int i=0; i<lost.length; i++){
            d[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++){
            d[reserve[i]]++;
        }
        
        for(int i=1; i<=n; i++){
            if(d[i]==2){
                if(i-1>0 && d[i-1]==0){
                    d[i-1]=1;
                    d[i]--;
                }
            }
            if(d[i]==2){
                if(i+1<=n && d[i+1]==0){
                    d[i+1]=1;
                    d[i]--;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(d[i]>=1) answer++;
        }
        return answer;
    }
}