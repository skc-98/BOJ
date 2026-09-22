class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zero = 0, match = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    match++;
                    break;
                }
            }
        }
        int max = 7 - (match + zero), min = 7 - match;
        if (max > 6) max = 6;
        if (min > 6) min = 6;
        answer = new int[]{max, min};
        return answer;
    }
}