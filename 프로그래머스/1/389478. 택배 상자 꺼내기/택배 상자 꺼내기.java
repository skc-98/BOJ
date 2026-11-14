class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] box = new int[(n - 1) / w + 1][w];
        int r = 0;
        int c = 0;
        for(int i = 1; i <= n; i++) {
            int j = (i - 1) / w;
            int k = (i - 1) % w;
            if(j % 2 == 1) {
                k = w - 1 - k;
            }
            box[j][k] = i;
            if(i == num) {
                r = j;
                c = k;
            }
        }
        for(int i = r; i < box.length; i++) {
            if(box[i][c] != 0) {
                answer++;
            }
        }
        return answer;
    }
}