import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        
        // 각 기능 완료까지 소요일 큐에 넣기
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0; i<speeds.length; i++){
            int days=100-progresses[i];
            if (days % speeds[i] == 0) {
                days = days / speeds[i];
            } else {
                days = days / speeds[i] + 1;
            }
            q.add(days);
        }
        
        // 이제 답 구하기
        int count=0, ans=0;
        while(!q.isEmpty()){
            if(count==0){
                count=q.poll();
                ans++;
            }
            else{
                if(count>=q.peek()){
                    q.poll();
                    ans++;
                }
                else{
                    count=0;
                    answer.add(ans);
                    ans=0;
                }
            }
        }
        answer.add(ans);
        
        return answer;
    }
}