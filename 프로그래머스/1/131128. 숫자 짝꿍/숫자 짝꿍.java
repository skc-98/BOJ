class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] x = new int[10];
        int[] y = new int[10];

        for(int i=0;i<X.length();i++) x[X.charAt(i)-'0']++;
        for(int i=0;i<Y.length();i++) y[Y.charAt(i)-'0']++;

        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=0;i--){
            int n = Math.min(x[i],y[i]);
            for(int j=0;j<n;j++) sb.append(i);
        }

        if(sb.length()==0) return "-1";
        if(sb.charAt(0)=='0') return "0";

        answer = sb.toString();
        return answer;
    }
}