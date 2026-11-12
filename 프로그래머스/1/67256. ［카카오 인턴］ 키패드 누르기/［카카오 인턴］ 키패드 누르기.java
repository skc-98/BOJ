class Solution {
    static final int[] x = {1,0,1,2,0,1,2,0,1,2,0,2};
    static final int[] y = {3,0,0,0,1,1,1,2,2,2,3,3};
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int l = 10, r = 11;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                l = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                r = numbers[i];
            } else {
                int ld = Math.abs(x[l] - x[numbers[i]]) + Math.abs(y[l] - y[numbers[i]]);
                int rd = Math.abs(x[r] - x[numbers[i]]) + Math.abs(y[r] - y[numbers[i]]);
                if (ld < rd || (ld == rd && hand.equals("left"))) {
                    answer += "L";
                    l = numbers[i];
                } else {
                    answer += "R";
                    r = numbers[i];
                }
            }
        }
        return answer;
    }
}