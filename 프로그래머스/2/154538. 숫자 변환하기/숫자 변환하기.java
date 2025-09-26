import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int ans = -1;
        
        // 방문배열, 큐 생성
        int[] visit=new int[5000000];
        Arrays.fill(visit, Integer.MAX_VALUE);
        Queue<Integer> q=new ArrayDeque<>();
        
        // 첫 요소 큐에 넣고 방문처리
        q.add(x);
        visit[x]=0;
        
        while(!q.isEmpty()){
            int now=q.poll();
            
            // 답 갱신
            if(now==y){
                ans=Math.max(ans, visit[now]);
                break;
            }
            
            // 3가지 연산 모두 진행
            if(now+n<=y && visit[now+n]>visit[now]+1){
                visit[now+n]=visit[now]+1;
                q.add(now+n);
            }
            if(now*2<=y && visit[now*2]>visit[now]+1){
                visit[now*2]=visit[now]+1;
                q.add(now*2);
            }
            if(now*3<=y && visit[now*3]>visit[now]+1){
                visit[now*3]=visit[now]+1;
                q.add(now*3);
            }
        }
        
        return ans;
    }
}