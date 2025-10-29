class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for(int i=food.length-1; i>=1; i--){
            if(food[i]%2!=0){
                food[i]--;
                for(int j=1; j<=food[i]/2; j++){
                    s1.append(i);
                    s2.append(i);
                }
            }
            else{
                for(int j=1; j<=food[i]/2; j++){
                    s1.append(i);
                    s2.append(i);
                }
            }
        }
        answer+=s2.reverse();
        answer+='0';
        answer+=s1;
        return answer;
    }
}