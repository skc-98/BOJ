class Solution {
    static int ans=0;
    public int solution(String begin, String target, String[] words) {
        visit=new boolean[words.length];
        dfs(0, begin, target, words);
        return ans;
    }
    
    static boolean[] visit;
    
    static void dfs(int depth, String now, String target, String[] words){
        // 종료 조건
        if(now.equals(target)){
            ans=depth;
            return;
        }
        
        // now를 세팅할 방법 => 재귀 호출이 여러번
        for(int i=0; i<words.length; i++){
            int count=0;
            if(visit[i]) continue;
            for(int j=0; j<words[i].length(); j++){
                if(words[i].charAt(j)==now.charAt(j)) count++;
            }
            if(count==now.length()-1){
                visit[i]=true;
                dfs(depth+1, words[i], target, words);
                visit[i]=false;
            }
        }
    }
}