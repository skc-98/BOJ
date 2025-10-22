import java.util.*;

class Solution {
    // 4방 벡터
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        // BFS용 큐랑 방문배열
        Queue<int[]> q=new ArrayDeque<>();
        int[][] visit=new int[maps.length][maps[0].length()];
        for (int[] row : visit) Arrays.fill(row, -1);
        
        // 시작점 찾기
        for(int i=0; i<maps.length; i++){
            boolean stop=false;
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j)=='S'){
                    q.add(new int[] {i,j});
                    visit[i][j]=0;
                    stop=true;
                    break;
                }
            }
            if(stop) break;
        }
        
        // 시작점에서 레버까지 BFS
        int ladderX=0, ladderY=0;
        int count=0;
        boolean findLadder=false;
        while(!q.isEmpty() && !findLadder){
            int x=q.peek()[0];
            int y=q.peek()[1];
            q.poll();
            
            // 4방 탐색
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];
                
                // 범위검사
                if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length() || visit[nx][ny]!=-1){
                    continue;
                }
                
                // 통로 여부랑 도착검사
                if(maps[nx].charAt(ny) != 'X'){
                    visit[nx][ny]=visit[x][y]+1;
                    q.add(new int[] {nx,ny});
                }
                if(maps[nx].charAt(ny)=='L'){
                    findLadder=true;
                    ladderX=nx;
                    ladderY=ny;
                    answer=visit[x][y]+1;
                    q.clear();
                    break;
                }
            }
        }
        
        // 초기화
        visit=new int[maps.length][maps[0].length()];
        for (int[] row : visit) Arrays.fill(row, -1);
        
        // 2차 최종 BFS
        int fx=0,fy=0;
        boolean findExit=false;
        q.add(new int[] {ladderX, ladderY});
        visit[ladderX][ladderY]=answer;
        while(!q.isEmpty() && findLadder){
            int x=q.peek()[0];
            int y=q.peek()[1];
            q.poll();
            
            // 4방 탐색
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];
                
                // 범위검사
                if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length() || visit[nx][ny]!=-1){
                    continue;
                }
                
                // 통로 여부랑 도착검사
                if(maps[nx].charAt(ny) != 'X'){
                    visit[nx][ny]=visit[x][y]+1;
                    q.add(new int[] {nx,ny});
                }
                if(maps[nx].charAt(ny)=='E'){
                    visit[nx][ny] = visit[x][y] + 1;
                    fx=nx;
                    fy=ny;
                    findExit=true;
                    q.clear();
                    break;
                }
            }
        }
        
        if(!findLadder || !findExit) visit[fx][fy]=-1;
        return visit[fx][fy];
    }
}