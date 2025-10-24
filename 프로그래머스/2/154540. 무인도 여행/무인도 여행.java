import java.util.*;

class Solution {
    // 4방향 벡터
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer=new ArrayList<>();
        
        // n,m으로 관리할거임
        int n=maps.length;
        int m=maps[0].length();
        
        // int형 배열로 복사
        int[][] d=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)=='X'){
                    d[i][j]=-1;
                    continue;
                }
                d[i][j]=maps[i].charAt(j)-'0';
            }
        }
        
        // 방문 배열, 큐
        boolean[][] visit=new boolean[n][m];
        Queue<int[]> q=new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                List<int[]> li=new ArrayList<>();
                if(d[i][j]!=-1 && !visit[i][j]){
                    q.add(new int[] {i,j});
                    li.add(new int[] {i,j});
                    visit[i][j]=true;
                    
                    while(!q.isEmpty()){
                        int x=q.peek()[0];
                        int y=q.peek()[1];
                        q.poll();
                        
                        for(int k=0; k<4; k++){
                            int nx=x+dx[k];
                            int ny=y+dy[k];
                            
                            if(nx<0 || nx>=n || ny<0 || ny>=m || visit[nx][ny] || d[nx][ny]==-1){
                                continue;
                            }
                            
                            q.add(new int[] {nx,ny});
                            li.add(new int[] {nx,ny});
                            visit[nx][ny]=true;
                        }
                    }
                }
                
                // 리스트에 더해둔 좌표 값 다 더해서 answer에 추가
                int sum=0;
                for(int k=0; k<li.size(); k++){
                    sum+=d[li.get(k)[0]][li.get(k)[1]];
                }
                if(sum!=0){
                    answer.add(sum);
                }
            }
        }
        if(answer.size()==0) answer.add(-1);
        Collections.sort(answer);
        return answer;
    }
}