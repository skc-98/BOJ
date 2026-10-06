class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int prev = 0;
        for (int i = 0; i < attacks.length; i++) {
            int time = attacks[i][0] - prev - 1;
            int heal = time * bandage[1] + (time / bandage[0]) * bandage[2];
            answer = Math.min(health, answer + heal) - attacks[i][1];
            if (answer <= 0) return -1;
            prev = attacks[i][0];
        }
        return answer;
    }
}