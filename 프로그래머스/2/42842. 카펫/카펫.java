import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum=brown+yellow;
        Map<Integer,Integer> mp=new HashMap<>();
        
        // 가로 세로 종류 찾기
        for(int i=sum; i>=Math.sqrt(sum); i--){
            if(sum%i==0){
                mp.put(i, sum/i);
            }
        }
        
        // 모든 경우에서 답 찾기
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if((entry.getKey()-2)*(entry.getValue()-2)==yellow){
                answer[0]=entry.getKey();
                answer[1]=entry.getValue();
            }
        }
        
        return answer;
    }
}