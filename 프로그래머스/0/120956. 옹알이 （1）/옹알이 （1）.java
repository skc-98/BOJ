class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            String word = babbling[i];
            word = word.replace("aya", " ");
            word = word.replace("ye", " ");
            word = word.replace("woo", " ");
            word = word.replace("ma", " ");
            word = word.replace(" ", "");
            if (word.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}